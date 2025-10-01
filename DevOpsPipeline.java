import java.util.Random;
import java.util.Scanner;

public class DevOpsPipeline {

    public static void build(String module) throws InterruptedException {
        System.out.println("Building module: " + module + "...");
        Thread.sleep(1500);
        System.out.println("Build successful for " + module + "!\n");
    }

    public static boolean test(String module) throws InterruptedException {
        System.out.println("Running tests for module: " + module + "...");
        Thread.sleep(1500);
        Random rand = new Random();
        boolean passed = rand.nextInt(4) != 3; // 75% chance to pass
        if (passed) {
            System.out.println("All tests passed for " + module + "!\n");
        } else {
            System.out.println("Tests failed for " + module + "!\n");
        }
        return passed;
    }

    public static void deploy(String module) throws InterruptedException {
        System.out.println("Deploying module: " + module + "...");
        Thread.sleep(1500);
        System.out.println("Deployment successful for " + module + "!\n");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String[] modules = {"Frontend", "Backend", "Database"};

        System.out.println("=== DevOps Pipeline Simulator ===\n");
        System.out.print("Press Enter to start the pipeline...");
        scanner.nextLine();

        boolean allPassed = true;
        for (String module : modules) {
            build(module);
            if (!test(module)) {
                allPassed = false;
                System.out.println("Pipeline stopped due to test failure in " + module + ".\n");
                break;
            }
            deploy(module);
        }

        if (allPassed) {
            System.out.println("All modules deployed successfully! Pipeline complete.");
        }

        scanner.close();
    }
}

