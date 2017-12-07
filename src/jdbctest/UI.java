package jdbctest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class UI {

    static Scanner sc = new Scanner(System.in);

    public static void MainMenu() throws SQLException {

        System.out.println("\nMain Menu - Operations on the Artists table\n===========");
        System.out.println("1. List all the entries");
        System.out.println("2. Add artist to the table");
        System.out.println("3. Update artist by ID");
        System.out.println("4. Delete artist by ID");
        System.out.println("5. Find artist by ID");
        System.out.println("6. Find artist by name");
        System.out.println("7. Find artist by year of birth");
        System.out.println("0. Exit");

        int result = sc.nextInt();

        switch (result) {
            case 1:
                printPrettyArrayofArtists(OperationsOnArtist.showAll());
                MainMenu();
                break;
            case 2:
                printPrettyArrayofArtists(OperationsOnArtist.showAll());
                System.out.println("Insert id, name, surname and birth year separated by a space: ");
                printPrettyArrayofArtists(OperationsOnArtist.addArtist(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
                MainMenu();
                break;
            case 3:
                printPrettyArrayofArtists(OperationsOnArtist.showAll());
                System.out.println("Insert id, name, surname and birth year separated by a space: ");
                printPrettyArrayofArtists(OperationsOnArtist.updateArtist(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
                MainMenu();
                break;
            case 4:
                printPrettyArrayofArtists(OperationsOnArtist.showAll());
                System.out.println("Insert id: ");
                printPrettyArrayofArtists(OperationsOnArtist.deleteArtist(sc.nextInt()));
                MainMenu();
                break;
            case 5:
                System.out.println("Insert id: ");
                printPrettyArrayofArtists(OperationsOnArtist.findById(sc.nextInt()));
                MainMenu();
                break;
            case 6:
                System.out.println("Insert name: ");
                printPrettyArrayofArtists(OperationsOnArtist.findByName(sc.next()));
                MainMenu();
                break;
            case 7:
                System.out.println("Insert year of birth: ");
                printPrettyArrayofArtists(OperationsOnArtist.findByBirthYear(sc.nextInt()));
                MainMenu();
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Selection failed - try again");
                MainMenu();

        }
    }

    public static void printPrettyArrayofArtists(ArrayList<Artist> list) {
        if (list.isEmpty()) {
            System.out.println("OOOPS! Nothing to show here");
        } else {
            System.out.println("ID  NAME                          SURNAME                       BIRTH YEAR");
            System.out.println("----------------------------------------------------------------------------");
            list.forEach((e) -> {
                System.out.println(e);
            });
        }
    }

}
