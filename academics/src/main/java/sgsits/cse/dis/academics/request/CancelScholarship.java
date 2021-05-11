package sgsits.cse.dis.academics.request;

import lombok.Getter;

import java.util.List;

@Getter
public class CancelScholarship {
    List<String> enrollments;
}
