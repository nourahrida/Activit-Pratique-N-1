package org.miniproject.service;


import org.miniproject.model.Exam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExamService {

    private final List<Exam> exams;

    public ExamService() {
        this.exams = new ArrayList<>();
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public List<Exam> getAllExams() {
        return new ArrayList<>(exams);
    }

    public Optional<Exam> getExamById(String examId) {
        return exams.stream()
                .filter(exam -> exam.getID().equals(examId))
                .findFirst();
    }

    public void updateExam(Exam updatedExam) {
        for (int i = 0; i < exams.size(); i++) {
            Exam exam = exams.get(i);
            if (exam.getID().equals(updatedExam.getID())) {
                exams.set(i, updatedExam);
                break;
            }
        }
    }

    public void deleteExam(String examId) {
        exams.removeIf(exam -> exam.getID().equals(examId));
    }

}

