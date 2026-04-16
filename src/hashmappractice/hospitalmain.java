package hashmappractice;

import java.util.*;

class HospitalSystem {

    // Phase 5: Main Data Structures (Bidirectional Mapping)
    private Map<Integer, String> patientToDoctor;
    private Map<String, List<Integer>> doctorToPatients;

    public HospitalSystem() {
        // You can switch implementations here for Phase 3 & 4
        patientToDoctor = new LinkedHashMap<>(); // maintains insertion order
        doctorToPatients = new HashMap<>();
    }

    // ---------------- PHASE 1 ----------------

    // Add assignment
    public void addAssignment(int patientId, String doctorName) {
        if (doctorToPatients.containsKey(doctorName) &&
            doctorToPatients.get(doctorName).size() >= 5) {
            System.out.println("Doctor " + doctorName + " already has 5 patients!");
            return;
        }

        patientToDoctor.put(patientId, doctorName);

        doctorToPatients.putIfAbsent(doctorName, new ArrayList<>());
        doctorToPatients.get(doctorName).add(patientId);
    }

    // Update doctor
    public void updateDoctor(int patientId, String newDoctor) {
        if (!patientToDoctor.containsKey(patientId)) {
            System.out.println("Patient not found!");
            return;
        }

        String oldDoctor = patientToDoctor.get(patientId);

        // Remove from old doctor
        doctorToPatients.get(oldDoctor).remove(Integer.valueOf(patientId));

        // Add to new doctor
        addAssignment(patientId, newDoctor);
    }

    // Remove patient
    public void removePatient(int patientId) {
        if (!patientToDoctor.containsKey(patientId)) return;

        String doctor = patientToDoctor.remove(patientId);
        doctorToPatients.get(doctor).remove(Integer.valueOf(patientId));
    }

    // Check existence
    public void checkPatient(int patientId) {
        System.out.println(patientToDoctor.containsKey(patientId));
    }

    // Get doctor
    public void getDoctor(int patientId) {
        System.out.println(patientToDoctor.get(patientId));
    }

    // Display using keySet
    public void displayUsingKeySet() {
        for (Integer id : patientToDoctor.keySet()) {
            System.out.println(id + " -> " + patientToDoctor.get(id));
        }
    }

    // Display using entrySet
    public void displayUsingEntrySet() {
        for (Map.Entry<Integer, String> entry : patientToDoctor.entrySet()) {
            System.out.println(entry);
        }
    }

    // Display using Iterator
    public void displayUsingIterator() {
        Iterator<Map.Entry<Integer, String>> it = patientToDoctor.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // Display using forEach
    public void displayUsingForEach() {
        patientToDoctor.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // ---------------- PHASE 2 ----------------

    // Get patients under doctor
    public void getPatientsByDoctor(String doctor) {
        System.out.println(doctorToPatients.getOrDefault(doctor, new ArrayList<>()));
    }

    // Count patients per doctor
    public void countPatients() {
        for (String doc : doctorToPatients.keySet()) {
            System.out.println(doc + " -> " + doctorToPatients.get(doc).size());
        }
    }

    // ---------------- PHASE 3 ----------------

    public void displayInsertionOrder() {
        System.out.println("Patients in admission order:");
        displayUsingForEach();
    }

    // ---------------- PHASE 4 ----------------

    public void displaySortedPatients() {
        TreeMap<Integer, String> sorted = new TreeMap<>(patientToDoctor);
        System.out.println(sorted);
    }

    public void displaySortedDoctors() {
        TreeMap<String, List<Integer>> sorted = new TreeMap<>(doctorToPatients);
        System.out.println(sorted);
    }

    // ---------------- PHASE 6 ----------------

    // Doctor with max patients
    public void doctorWithMaxPatients() {
        String maxDoctor = null;
        int max = 0;

        for (String doc : doctorToPatients.keySet()) {
            int size = doctorToPatients.get(doc).size();
            if (size > max) {
                max = size;
                maxDoctor = doc;
            }
        }

        System.out.println("Max Patients Doctor: " + maxDoctor + " (" + max + ")");
    }

    // Sort patient count descending
    public void sortDoctorsByPatientCount() {
        List<Map.Entry<String, List<Integer>>> list =
                new ArrayList<>(doctorToPatients.entrySet());

        list.sort((a, b) -> b.getValue().size() - a.getValue().size());

        for (Map.Entry<String, List<Integer>> e : list) {
            System.out.println(e.getKey() + " -> " + e.getValue().size());
        }
    }

    // Transfer all patients
    public void transferPatients(String fromDoc, String toDoc) {
        if (!doctorToPatients.containsKey(fromDoc)) return;

        List<Integer> patients = new ArrayList<>(doctorToPatients.get(fromDoc));

        for (int p : patients) {
            updateDoctor(p, toDoc);
        }
    }

    // Hospital report
    public void hospitalReport() {
        System.out.println("Total Patients: " + patientToDoctor.size());
        System.out.println("Total Doctors: " + doctorToPatients.size());
        doctorWithMaxPatients();
    }
}

// ---------------- MAIN CLASS ----------------

public class hospitalmain {
    public static void main(String[] args) {

        HospitalSystem hs = new HospitalSystem();

        // Sample Data
        hs.addAssignment(1, "Dr. Smith");
        hs.addAssignment(2, "Dr. Smith");
        hs.addAssignment(3, "Dr. John");
        hs.addAssignment(4, "Dr. John");
        hs.addAssignment(5, "Dr. Alex");

        // Phase 1 Demo
        hs.displayUsingForEach();

        // Update
        hs.updateDoctor(1, "Dr. Alex");

        // Phase 2
        hs.getPatientsByDoctor("Dr. Alex");
        hs.countPatients();

        // Phase 3
        hs.displayInsertionOrder();

        // Phase 4
        hs.displaySortedPatients();
        hs.displaySortedDoctors();

        // Phase 6
        hs.doctorWithMaxPatients();
        hs.sortDoctorsByPatientCount();

        // Transfer
        hs.transferPatients("Dr. John", "Dr. Smith");

        // Final Report
        hs.hospitalReport();
    }
}