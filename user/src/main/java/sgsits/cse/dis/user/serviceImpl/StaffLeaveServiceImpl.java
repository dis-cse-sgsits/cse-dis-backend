package sgsits.cse.dis.user.serviceImpl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.ApplyStaffLeaveForm;
import sgsits.cse.dis.user.message.request.CreateStaffLeaveForm;
import sgsits.cse.dis.user.message.request.StaffLeaveCreditForm;
import sgsits.cse.dis.user.message.request.StaffRejoinForm;
import sgsits.cse.dis.user.message.request.UpdateStatusForm;
import sgsits.cse.dis.user.message.response.StaffLeaveAccountResponse;
import sgsits.cse.dis.user.message.response.StaffLeaveLeftResponse;
import sgsits.cse.dis.user.model.Holiday;
import sgsits.cse.dis.user.model.StaffAnnualLeave;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StaffLeave;
import sgsits.cse.dis.user.model.StaffLeaveTypes;
import sgsits.cse.dis.user.model.StaffLifelongLeave;
import sgsits.cse.dis.user.repo.HolidayRepository;
import sgsits.cse.dis.user.repo.StaffAnnualLeaveRepository;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.repo.StaffLeaveRepository;
import sgsits.cse.dis.user.repo.StaffLeaveTypeRepository;
import sgsits.cse.dis.user.repo.StaffLifelongLeaveRepository;
import sgsits.cse.dis.user.service.StaffLeaveService;

@Component
public class StaffLeaveServiceImpl implements StaffLeaveService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private StaffLeaveRepository staffLeaveRepository;

    @Autowired
    private StaffBasicProfileRepository staffRepository;

    @Autowired
    private StaffLeaveTypeRepository staffLeaveTypeRepository;

    @Autowired
    private StaffLifelongLeaveRepository staffLifelongLeaveRepository;

    @Autowired
    private StaffAnnualLeaveRepository staffAnnualLeaveRepository;

    @Autowired
    private HolidayRepository holidayRepository;

    public double getDays(String fromDate, String toDate, boolean considerHolidays, String fromDuration,
            String toDuration) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse(fromDate);
        Date date2 = df.parse(toDate);

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        // cal2.add(Calendar.DATE, 1);
        double numberOfDays = 0;

        if (!fromDuration.equals("full")) {
            numberOfDays = numberOfDays + 0.5;
            cal1.add(Calendar.DATE, 1);
        }

        if (!fromDate.equals(toDate)) {
            if (!toDuration.equals("full")) {
                numberOfDays = numberOfDays + 0.5;
                cal2.add(Calendar.DATE, -1);
            }
        }
        if (considerHolidays) {
            while (cal1.compareTo(cal2) <= 0) {
                numberOfDays++;
                cal1.add(Calendar.DATE, 1);
            }
            return numberOfDays;
        }
        List<Holiday> holidays = holidayRepository.findAll();
        List<String> dates = new ArrayList<String>();
        for (Holiday h : holidays) {
            dates.add(h.getDate());
        }
        while (cal1.compareTo(cal2) <= 0) {
            Date d = cal1.getTime();
            String strDate = df.format(d);

            if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                    && (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK)) && !dates.contains(strDate)) {
                numberOfDays++;
            }
            cal1.add(Calendar.DATE, 1);
        }
        // System.out.println(numberOfDays);
        return numberOfDays;
    }

    @Override
    @Transactional
    public Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm) throws ConflictException, ParseException {

        String userId = applyStaffLeaveForm.getUserId();
        StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(applyStaffLeaveForm.getTypeOfLeave());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fdate = applyStaffLeaveForm.getFromDate();
        String tdate = applyStaffLeaveForm.getToDate();

        if (leaveType.getLeaveType().equals("annual")) {
            try {
                if (simpleDateFormat.parse(fdate).compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0
                        || simpleDateFormat.parse(leaveType.getToDate()).compareTo(simpleDateFormat.parse(tdate)) < 0) {
                    throw new ConflictException("Leave cannot be applied due to date issue.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        StaffLeave staffLeave = new StaffLeave();
        staffLeave.setFromDate(applyStaffLeaveForm.getFromDate());
        staffLeave.setToDate(applyStaffLeaveForm.getToDate());
        staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
        staffLeave.setCreatedDate(simpleDateFormat.format(new Date()));
        staffLeave.setAppliedBy(applyStaffLeaveForm.getAppliedBy());
        staffLeave.setDetails(applyStaffLeaveForm.getDetails());
        staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
        staffLeave.setStatus(applyStaffLeaveForm.getStatus());
        staffLeave.setFromDuration(applyStaffLeaveForm.getFromDuration());
        staffLeave.setToDuration(applyStaffLeaveForm.getToDuration());
        staffLeave.setConsiderHolidays(applyStaffLeaveForm.isConsiderHolidays());
        staffLeave.setSubject(applyStaffLeaveForm.getSubject());
        staffLeave.setTypeOfLeave(applyStaffLeaveForm.getTypeOfLeave());
        staffLeave.setUserId(userId);
        staffLeave.setNoOfDays(getDays(applyStaffLeaveForm.getFromDate(), applyStaffLeaveForm.getToDate(),
                applyStaffLeaveForm.isConsiderHolidays(), applyStaffLeaveForm.getFromDuration(),
                applyStaffLeaveForm.getToDuration()));

        StaffLeave test = staffLeaveRepository.save(staffLeave);
        return test.getLeaveId();
    }

    @Override
    public List<StaffLeave> getLeavesByStatus(String status) {
        return staffLeaveRepository.findByStatusIgnoreCase(status);
    }

    @Override
    @Transactional
    public int updateStatusByLeaveId(UpdateStatusForm updateStatus) throws ConflictException {

        Long leaveId = updateStatus.getLeaveId();
        String status = updateStatus.getStatus();
        status = status.toLowerCase();
        StaffLeave leave = staffLeaveRepository.findByLeaveId(leaveId);
        String leaveName = leave.getTypeOfLeave();
        String type = staffLeaveTypeRepository.findByLeaveName(leaveName).getLeaveType();
        StaffLeaveTypes slt = staffLeaveTypeRepository.findByLeaveName(leaveName);

        StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(leave.getTypeOfLeave());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fdate = leave.getFromDate();
        String tdate = leave.getToDate();

        if (leaveType.getLeaveType().equals("annual")) {
            try {
                if (simpleDateFormat.parse(fdate).compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0
                        || simpleDateFormat.parse(leaveType.getToDate()).compareTo(simpleDateFormat.parse(tdate)) < 0) {
                    throw new ConflictException("Leave cannot be applied due to date issue.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("lifelong")) {
            if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(leave.getUserId(), leaveName)) {
                addToTable(leaveName, leave.getUserId());
            }

        } else {
            if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(leave.getUserId(), leaveName,
                    slt.getToDate())) {
                addToTable(leaveName, leave.getUserId());
            }

        }
        if (status.equals("approved") && !leave.getStatus().equals("approved")) {
            double days;
            days = leave.getNoOfDays();

            System.out.println("days" + days);
            if (type.equals("lifelong")) {
                StaffLifelongLeave leave2 = staffLifelongLeaveRepository.findByUserIdAndLeaveName(leave.getUserId(),
                        leaveName);
                leave2.setLeavesApplied(leave2.getLeavesApplied() + days);
                leave2.setLeavesLeft(leave2.getLeavesLeft() - days);
                staffLifelongLeaveRepository.save(leave2);
            } else {
                StaffAnnualLeave leave2 = staffAnnualLeaveRepository
                        .findByUserIdAndLeaveNameAndToDate(leave.getUserId(), leaveName, slt.getToDate());
                leave2.setLeavesApplied(leave2.getLeavesApplied() + days);
                leave2.setLeavesLeft(leave2.getLeavesLeft() - days);
                staffAnnualLeaveRepository.save(leave2);
            }
        }
        leave.setStatus(status);
        staffLeaveRepository.save(leave);
        return 1;
    }

    public void addToTable(String leaveName, String userId) {
        StaffLeaveTypes slt = staffLeaveTypeRepository.findByLeaveName(leaveName);
        if (slt.getLeaveType().equals("lifelong")) {
            StaffLifelongLeave staffLifelongLeave = new StaffLifelongLeave();
            staffLifelongLeave.setLeaveName(leaveName);
            staffLifelongLeave.setUserId(userId);
            staffLifelongLeave.setLeavesApplied(0);
            staffLifelongLeave.setLeavesLeft(slt.getNoOfLeaves());
            staffLifelongLeaveRepository.save(staffLifelongLeave);
        } else {
            StaffAnnualLeave staffAnnualLeave = new StaffAnnualLeave();
            staffAnnualLeave.setLeaveName(leaveName);
            staffAnnualLeave.setLeavesApplied(0);
            staffAnnualLeave.setLeavesLeft(slt.getNoOfLeaves());
            staffAnnualLeave.setToDate(slt.getToDate());
            staffAnnualLeave.setUserId(userId);
            staffAnnualLeaveRepository.save(staffAnnualLeave);
        }
    }

    public List<StaffLeaveAccountResponse> getLeaveLeft(String userName) {
        List<StaffLeaveAccountResponse> res = new ArrayList<StaffLeaveAccountResponse>();
        List<StaffBasicProfile> staff = staffRepository.findByNameContainingIgnoreCase(userName);
        List<StaffLeaveTypes> allLeave = staffLeaveTypeRepository.findAll();

        for (StaffBasicProfile s : staff) {
            StaffLeaveAccountResponse account = new StaffLeaveAccountResponse();
            List<StaffLeaveLeftResponse> annual = new ArrayList<StaffLeaveLeftResponse>();
            List<StaffLeaveLeftResponse> lifelong = new ArrayList<StaffLeaveLeftResponse>();
            String userId = s.getUserId();
            account.setUserId(s.getUserId());
            for (StaffLeaveTypes a : allLeave) {
                StaffLeaveLeftResponse r = new StaffLeaveLeftResponse();
                if (a.getLeaveType().equals("annual")) {
                    if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(userId, a.getLeaveName(),
                            a.getToDate())) {
                        addToTable(a.getLeaveName(), userId);
                    }
                    StaffAnnualLeave sal = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(userId,
                            a.getLeaveName(), a.getToDate());

                    r.setLeaveName(a.getLeaveName());
                    r.setLeavesApplied(sal.getLeavesApplied());
                    r.setLeavesLeft(sal.getLeavesLeft());
                    r.setToDate(sal.getToDate());
                    annual.add(r);
                } else {
                    if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(userId, a.getLeaveName())) {
                        addToTable(a.getLeaveName(), userId);
                    }
                    StaffLifelongLeave sal = staffLifelongLeaveRepository.findByUserIdAndLeaveName(userId,
                            a.getLeaveName());

                    r.setLeaveName(a.getLeaveName());
                    r.setLeavesApplied(sal.getLeavesApplied());
                    r.setLeavesLeft(sal.getLeavesLeft());
                    lifelong.add(r);
                }
            }
            account.setAnnual(annual);
            account.setLifelong(lifelong);
            res.add(account);
        }
        return res;
    }

    public List<StaffLeave> getAllLeavesByName(String name) {
        List<StaffLeave> leaves = new ArrayList<StaffLeave>();
        Optional<StaffBasicProfile> s = staffRepository.findByName(name);
        if (s.isPresent()) {
            StaffBasicProfile st = s.get();
            leaves = staffLeaveRepository.findByUserId(st.getUserId());
        }
        return leaves;
    }

    @Override
    public int createNewLeave(CreateStaffLeaveForm createStaffLeaveForm) throws ConflictException {
        if (createStaffLeaveForm.getLeaveType().equals("annual") && createStaffLeaveForm.getToDate() != null) {
            StaffLeaveTypes staffLeaveTypes = new StaffLeaveTypes();
            staffLeaveTypes.setDescription(createStaffLeaveForm.getDescription());
            staffLeaveTypes.setLeaveName(createStaffLeaveForm.getLeaveName());
            staffLeaveTypes.setNoOfLeaves(createStaffLeaveForm.getNoOfLeaves());
            staffLeaveTypes.setLeaveType(createStaffLeaveForm.getLeaveType());
            staffLeaveTypes.setFromDate(createStaffLeaveForm.getFromDate());
            staffLeaveTypes.setToDate(createStaffLeaveForm.getToDate());
            staffLeaveTypeRepository.save(staffLeaveTypes);
            return 1;
        } else if (createStaffLeaveForm.getLeaveType().equals("lifelong")) {
            StaffLeaveTypes staffLeaveTypes = new StaffLeaveTypes();
            staffLeaveTypes.setDescription(createStaffLeaveForm.getDescription());
            staffLeaveTypes.setLeaveName(createStaffLeaveForm.getLeaveName());
            staffLeaveTypes.setNoOfLeaves(createStaffLeaveForm.getNoOfLeaves());
            staffLeaveTypes.setLeaveType(createStaffLeaveForm.getLeaveType());
            staffLeaveTypeRepository.save(staffLeaveTypes);
            return 1;
        } else {
            throw new ConflictException("new leave cannot be created");
        }

    }

    @Override
    public List<StaffLeaveTypes> getAllLeaveTypes() {
        List<StaffLeaveTypes> leaves = new ArrayList<StaffLeaveTypes>();
        leaves = staffLeaveTypeRepository.findAll();
        return leaves;
    }

    @Override
    @Transactional
    public void rejoin(StaffRejoinForm staffRejoinForm) {
        StaffLeave leave = staffLeaveRepository.findByLeaveId(staffRejoinForm.getLeaveId());
        leave.setStatus("rejoined");
        double daysBefore = leave.getNoOfDays();
        double daysAfter = 0;
        try {
            daysAfter = getDays(leave.getFromDate(), staffRejoinForm.getRejoinDate(), leave.isConsiderHolidays(),
                    leave.getFromDuration(), leave.getToDuration());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(leave.getTypeOfLeave());
        if (leaveType.getLeaveType().equals("annual")) {
            StaffAnnualLeave l = staffAnnualLeaveRepository.findByUserIdAndLeaveNameAndToDate(leave.getUserId(),
                    leave.getTypeOfLeave(), leaveType.getToDate());
            l.setLeavesApplied(l.getLeavesApplied() - daysBefore + daysAfter);
            l.setLeavesLeft(l.getLeavesLeft() + daysBefore - daysAfter);
            staffAnnualLeaveRepository.save(l);
        } else {
            StaffLifelongLeave l = staffLifelongLeaveRepository.findByUserIdAndLeaveName(leave.getUserId(),
                    leave.getTypeOfLeave());
            l.setLeavesApplied(l.getLeavesApplied() - daysBefore + daysAfter);
            l.setLeavesLeft(l.getLeavesLeft() + daysBefore - daysAfter);
            staffLifelongLeaveRepository.save(l);
        }
        leave.setNoOfDays(daysAfter);
        staffLeaveRepository.save(leave);
    }

    @Override
    @Transactional
    public String creditLeave(StaffLeaveCreditForm staffLeaveCreditForm) throws ConflictException {
        String leaveName = staffLeaveCreditForm.getLeaveName();
        StaffLeaveTypes leave = staffLeaveTypeRepository.findByLeaveName(leaveName);
        for (String s : staffLeaveCreditForm.getFacultyNames()) {

            String userId;
            Optional<StaffBasicProfile> sp = staffRepository.findByName(s);
            System.out.println("Faculty " + s);
            if (sp.isPresent()) {
                StaffBasicProfile st = sp.get();
                userId = st.getUserId();
            } else {
                throw new ConflictException("User " + s + " does not exist. Rollback!");
            }
            if (leave.getLeaveType().equals("annual")) {
                if (!staffAnnualLeaveRepository.existsByUserIdAndLeaveNameAndToDate(userId, leaveName,
                        leave.getToDate())) {
                    addToTable(leaveName, userId);
                }
                staffAnnualLeaveRepository.creditLeave(staffLeaveCreditForm.getLeaveToCredit(), userId,
                        leave.getToDate(), leaveName);
            } else if (leave.getLeaveType().equals("lifelong")) {
                if (!staffLifelongLeaveRepository.existsByUserIdAndLeaveName(userId, leaveName)) {
                    addToTable(leaveName, userId);
                }
                staffLifelongLeaveRepository.creditLeave(staffLeaveCreditForm.getLeaveToCredit(), userId, leaveName);
            } else {
                throw new ConflictException("can't get leave type.");
            }
        }
        return "Leave Credited";
    }

    public long updateLeave(ApplyStaffLeaveForm applyStaffLeaveForm) throws ConflictException, ParseException
    {
        String userId = applyStaffLeaveForm.getUserId();
        StaffLeaveTypes leaveType = staffLeaveTypeRepository.findByLeaveName(applyStaffLeaveForm.getTypeOfLeave());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fdate = applyStaffLeaveForm.getFromDate();
        String tdate = applyStaffLeaveForm.getToDate();

        if (leaveType.getLeaveType().equals("annual")) {
            try {
                if (simpleDateFormat.parse(fdate).compareTo(simpleDateFormat.parse(leaveType.getFromDate())) < 0
                        || simpleDateFormat.parse(leaveType.getToDate()).compareTo(simpleDateFormat.parse(tdate)) < 0) {
                    throw new ConflictException("Leave cannot be updated due to date issue.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        StaffLeave staffLeave = new StaffLeave();
        staffLeave.setLeaveId(applyStaffLeaveForm.getLeaveId());
        staffLeave.setFromDate(applyStaffLeaveForm.getFromDate());
        staffLeave.setToDate(applyStaffLeaveForm.getToDate());
        staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
        staffLeave.setCreatedDate(simpleDateFormat.format(new Date()));
        staffLeave.setAppliedBy(applyStaffLeaveForm.getAppliedBy());
        staffLeave.setDetails(applyStaffLeaveForm.getDetails());
        staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
        staffLeave.setStatus(applyStaffLeaveForm.getStatus());
        staffLeave.setFromDuration(applyStaffLeaveForm.getFromDuration());
        staffLeave.setToDuration(applyStaffLeaveForm.getToDuration());
        staffLeave.setConsiderHolidays(applyStaffLeaveForm.isConsiderHolidays());
        staffLeave.setSubject(applyStaffLeaveForm.getSubject());
        staffLeave.setTypeOfLeave(applyStaffLeaveForm.getTypeOfLeave());
        staffLeave.setUserId(userId);
        staffLeave.setNoOfDays(getDays(applyStaffLeaveForm.getFromDate(), applyStaffLeaveForm.getToDate(),
                applyStaffLeaveForm.isConsiderHolidays(), applyStaffLeaveForm.getFromDuration(),
                applyStaffLeaveForm.getToDuration()));

        StaffLeave test = staffLeaveRepository.save(staffLeave);
        return test.getLeaveId();
    }

}

// public long getDays(String fromDate, String toDate) throws ParseException {
// String one = fromDate;
// String two = toDate;
// SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
// long diff = myFormat.parse(two).getTime() - myFormat.parse(one).getTime();
// return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
// }

// @Override
// @Transactional
// public Long applyLeave(ApplyStaffLeaveForm applyStaffLeaveForm) {

// String userId = applyStaffLeaveForm.getUserId();
// int year = Calendar.getInstance().get(Calendar.YEAR);

// if (!staffLeaveLeftRepository.existsByUserIdAndYear(userId, year)) {
// long maxLeaves =
// staffLeaveSettingsRepository.findTopByOrderByIdDesc().getMaxLeaves();
// StaffLeaveLeft staffLeaveLeft = new StaffLeaveLeft();
// staffLeaveLeft.setUserId(userId);
// staffLeaveLeft.setYear(year);
// staffLeaveLeft.setLeavesLeft(maxLeaves);
// staffLeaveLeft.setUsername(applyStaffLeaveForm.getAppliedBy());
// staffLeaveLeftRepository.save(staffLeaveLeft);
// }

// DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
// StaffLeave staffLeave = new StaffLeave();
// staffLeave.setFromDate(applyStaffLeaveForm.getFromDate());
// staffLeave.setToDate(applyStaffLeaveForm.getToDate());
// staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
// staffLeave.setCreatedDate(simpleDateFormat.format(new Date()));
// staffLeave.setAppliedBy(applyStaffLeaveForm.getAppliedBy());
// staffLeave.setDetails(applyStaffLeaveForm.getDetails());
// staffLeave.setRemarks(applyStaffLeaveForm.getRemarks());
// staffLeave.setStatus("applied");
// staffLeave.setHalfdayFullday(applyStaffLeaveForm.getHalfdayFullday());
// staffLeave.setSubject(applyStaffLeaveForm.getSubject());
// staffLeave.setTypeOfLeave(applyStaffLeaveForm.getTypeOfLeave());
// staffLeave.setUserId(userId);

// StaffLeave test = staffLeaveRepository.save(staffLeave);
// return test.getLeaveId();
// }

// @Override
// @Transactional
// public void updateStatusByLeaveId(UpdateStatusForm updateStatus) {
// Long leaveId = updateStatus.getLeaveId();
// String status = updateStatus.getStatus();
// status = status.toLowerCase();
// if (status.equals("approved"))
// {
// StaffLeave leave = staffLeaveRepository.findByLeaveId(leaveId);
// if(!leave.getStatus().equals("approved"))
// {

// long days;
// days = 0;
// int year = Calendar.getInstance().get(Calendar.YEAR);
// try {
// days = getDays(leave.getFromDate(), leave.getToDate());
// } catch (ParseException e) {
// e.printStackTrace();
// }
// String userId = leave.getUserId();
// StaffLeaveLeft staffLeaveLeft =
// staffLeaveLeftRepository.findByUserIdAndYear(userId, year);
// long leavesLeft = staffLeaveLeft.getLeavesLeft() - days;
// // System.out.println("days left"+leavesLeft);
// staffLeaveLeftRepository.updateStaffLeaveLeftInfo(leavesLeft, userId, year);
// }
// }
// staffLeaveRepository.updateStatusByLeaveId(leaveId, status);
// }

// public List<StaffLeaveLeftResponse> getLeaveLeft(String userName) {
// int year = Calendar.getInstance().get(Calendar.YEAR);
// long leavesLeft;
// List<StaffBasicProfile> staff =
// staffRepository.findByNameContainingIgnoreCase(userName);
// List<StaffLeaveLeftResponse> res = new ArrayList<StaffLeaveLeftResponse>();
// for (StaffBasicProfile s : staff) {
// StaffLeaveLeftResponse r = new StaffLeaveLeftResponse();
// if (!staffLeaveLeftRepository.existsByUserIdAndYear(s.getUserId(), year)) {
// leavesLeft =
// staffLeaveSettingsRepository.findTopByOrderByIdDesc().getMaxLeaves();
// } else {
// StaffLeaveLeft st =
// staffLeaveLeftRepository.findByUserIdAndYear(s.getUserId(), year);
// leavesLeft = st.getLeavesLeft();
// }

// r.setLeavesLeft(leavesLeft);
// r.setUserName(s.getName());
// res.add(r);
// }
// return res;
// }

// @Override
// @Transactional
// public long updateSettings(StaffLeaveSettingsForm staffLeaveSettingsForm) {
// StaffLeaveSettings staffLeaveSettings = new StaffLeaveSettings();
// staffLeaveSettings.setMaxLeaves(staffLeaveSettingsForm.getMaxLeaves());
// staffLeaveSettingsRepository.save(staffLeaveSettings);
// return staffLeaveSettings.getMaxLeaves();
// }

// @Override
// public StaffLeaveSettings getSettings() {
// return staffLeaveSettingsRepository.findTopByOrderByIdDesc();
// }