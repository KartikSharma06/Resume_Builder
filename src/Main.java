import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Resume Builder!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Select a template:");
        System.out.println("1. Template 1");
        System.out.println("2. Template 2");
        System.out.print("Enter template number: ");
        int templateChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String template = (templateChoice == 1) ? "Template 1" : "Template 2";

        System.out.println("Enter your education information:");
        System.out.print("Education: ");
        String education = scanner.nextLine();

        System.out.println("Enter your experience information:");
        System.out.print("Experience: ");
        String experience = scanner.nextLine();

        System.out.println("Enter your skills:");
        System.out.print("Skills: ");
        String skills = scanner.nextLine();

        System.out.println("Language preference");
        System.out.print("Language: ");
        String language = scanner.nextLine();

        // Create a Resume object
        Resume resume = new Resume(name, email, template, education, experience, skills,language);

        // Generate and save resume as a text file
        String filePath = generateResume(resume);

        System.out.println("Your resume has been generated and saved at: " + filePath);
    }

    private static String generateResume(Resume resume) {
        String fileName = "generated-resume.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String content = "Name: " + resume.getName() + "\n" +
                    " Email: " + resume.getEmail() + "\n" +
                    " Template: " + resume.getTemplate() + "\n" +
                    " Education: " + resume.getEducation() + "\n" +
                    " Experience: " + resume.getExperience() + "\n" +
                    " Skills: " + resume.getSkills() + "\n" +
                    " Language: " +resume.getLanguage();

            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}

class Resume {
    private String name;
    private String email;
    private String template;
    private String education;
    private String experience;
    private String skills;
    private String language;

    public Resume(String name, String email, String template, String education, String experience, String skills, String language) {
        this.name = name;
        this.email = email;
        this.template = template;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTemplate() {
        return template;
    }

    public String getEducation() {
        return education;
    }

    public String getExperience() {
        return experience;
    }

    public String getSkills() {
        return skills;
    }

    public String getLanguage(){ return language;}
}




