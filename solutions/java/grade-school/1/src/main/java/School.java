import java.util.*;

class School {

    Map<Integer, Set<String>> grades = new TreeMap<>();

    boolean add(String student, int grade) {

        boolean isAlreadyEnrolled = grades.values().stream()
                                                    .flatMap(Set::stream).anyMatch(s -> s.equals(student));

        if(isAlreadyEnrolled) return false;

        return grades.computeIfAbsent(grade, _ -> new TreeSet<>()).add(student);
        
    }

    List<String> roster() {
        return grades.values().stream().flatMap(Set::stream).toList();
    }

    List<String> grade(int grade) {
        Set<String> gradeSet = grades.getOrDefault(grade, new TreeSet<>());
        
        return new ArrayList<>(gradeSet);
    }
}