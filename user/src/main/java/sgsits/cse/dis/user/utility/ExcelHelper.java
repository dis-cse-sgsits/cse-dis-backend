package sgsits.cse.dis.user.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.model.StudentProfile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<StudentProfile> excelToStudents(InputStream is, String createdBy, int sheetNo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(workbook.getSheetName(sheetNo));
            Iterator<Row> rows = sheet.iterator();
            List<StudentProfile> students = new ArrayList<StudentProfile>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                StudentProfile student = new StudentProfile();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            student.setEnrollmentId(currentCell.getStringCellValue());
                            break;

                        case 1:
                            student.setFullName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            student.setAdmissionYear((int)currentCell.getNumericCellValue());
                            break;

                        case 3:
                            student.setCourseId(currentCell.getStringCellValue());
                            break;

                        case 4:
                            student.setMobileNo((long)currentCell.getNumericCellValue());
                            break;

                        case 5:
                            System.out.println();
                            java.sql.Date dob = new java.sql.Date(currentCell.getDateCellValue().getDate());
                            student.setDob(dob);
                            break;

                        case 6:
                            student.setCategory(currentCell.getStringCellValue());
                            break;

                        case 7:
                            student.setGender(currentCell.getStringCellValue());
                            break;

                        case 8:
                            student.setBloodGroup(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }
                    student.setCreatedBy(createdBy);
                    student.setCreatedDate(simpleDateFormat.format(new Date()));
                    cellIdx++;
                }

                students.add(student);
            }

            workbook.close();

            return students;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    public static List<StaffBasicProfile> excelToStaff(InputStream is, String createdBy, int sheetNo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(workbook.getSheetName(sheetNo));
            Iterator<Row> rows = sheet.iterator();
            List<StaffBasicProfile> staff = new ArrayList<StaffBasicProfile>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                StaffBasicProfile member = new StaffBasicProfile();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            System.out.println(cellIdx);
                            member.setEmployeeId(String.valueOf((int)currentCell.getNumericCellValue()));
                            break;

                        case 1:
                            System.out.println(cellIdx);
                            member.setName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            System.out.println(cellIdx);
                            member.setNameAcronym(currentCell.getStringCellValue());
                            break;

                        case 3:
                            System.out.println(cellIdx);
                            member.setCurrentDesignation(currentCell.getStringCellValue());
                            break;

                        case 4:
                            System.out.println(cellIdx);
                            member.setClasss(currentCell.getStringCellValue());
                            break;

                        case 5:
                            System.out.println(cellIdx);
                            java.sql.Date dob = new java.sql.Date(currentCell.getDateCellValue().getDate());
                            member.setDob(dob);
                            break;

                        case 6:
                            System.out.println(cellIdx);
                            member.setType(currentCell.getStringCellValue());
                            break;

                        case 7:
                            System.out.println(cellIdx);
                            member.setGender(currentCell.getStringCellValue());
                            break;

                        case 8:
                            System.out.println(cellIdx);
                            member.setBloodGroup(currentCell.getStringCellValue());
                            break;

                        case 9:
                            System.out.println(cellIdx);
                            member.setEmail(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }
                    member.setCreatedBy(createdBy);
                    member.setCreatedDate(simpleDateFormat.format(new Date()));
                    cellIdx++;
                }

                staff.add(member);
            }

            workbook.close();

            return staff;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}