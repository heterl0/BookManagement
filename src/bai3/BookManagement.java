package bai3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class BookManagement {

    ArrayList<Document> list;

    public BookManagement() {
        list = new ArrayList<>();
    }

    private int chooseDocument() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean isChoiceValid = false;
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. Newspaper");
        System.out.print("Your choice: ");
        do {
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.print("Error: enter (1-3)! Again: ");
                } else {
                    isChoiceValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("Error: enter (1-3)! Again: ");
            }
            sc.nextLine();
        } while (isChoiceValid == false);
        return choice;
    }

    public boolean addDocument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- - - - [Add Document] - - - -");
        int choice = chooseDocument();
        int idDocument = 0, numOfRelease = 0, monRelease = 0, numberOfPages = 0, numberOfCopy = 0, seri = 0;
        String publisher, author, date;
        boolean isValid = false;
        do {
            try {
                System.out.print("Enter id: ");
                idDocument = sc.nextInt();
                if (idDocument <= 0 || isExisted(idDocument)) {
                    System.out.println("ID mustn't be negative or zero! or ID has been existed!");
                } else {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ID mustn't be negative or zero! or ID has been existed!");
            }
            sc.nextLine();
        } while (isValid == false);

        isValid = false;
        do {
            System.out.print("Enter Publisher: ");
            publisher = sc.nextLine().trim();
            if (publisher.equals("")) {
                System.out.println("Publisher can't be empty!");
            } else {
                isValid = true;
            }
        } while (isValid == false);

        isValid = false;
        do {
            try {
                System.out.print("Enter number of copy: ");
                numOfRelease = sc.nextInt();
                if (numOfRelease <= 0) {
                    System.out.println("Number of copy must be a positive number");
                } else {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Number of copy must be a positive number");
            }
            sc.nextLine();
        } while (isValid == false);

        switch (choice) {
            case 1:
                isValid = false;
                do {
                    System.out.print("Enter author: ");
                    author = sc.nextLine().trim();
                    if (author.equals("")) {
                        System.out.println("Author can't be empty!");
                    } else {
                        isValid = true;
                    }
                } while (isValid == false);

                isValid = false;
                do {
                    try {
                        System.out.print("Enter number of page: ");
                        numberOfPages = sc.nextInt();
                        if (numberOfPages <= 0) {
                            System.out.println("Number of page must be a positive number");
                        } else {
                            isValid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Number of page must be a positive number");
                    }
                    sc.nextLine();
                } while (isValid == false);
                list.add(new Book(idDocument, publisher, numOfRelease, author, numberOfPages));
                break;
            case 2:
                isValid = false;
                do {
                    try {
                        System.out.print("Enter the seri number: ");
                        seri = sc.nextInt();
                        if (seri <= 0) {
                            System.out.println("The seri number must be a positive number");
                        } else {
                            isValid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("The seri number must be a positive number");
                    }
                    sc.nextLine();
                } while (isValid == false);
                isValid = false;
                do {
                    try {
                        System.out.print("Enter month release: ");
                        monRelease = sc.nextInt();
                        if (monRelease < 1 || monRelease > 12) {
                            System.out.println("Month release must be from 1 to 12");
                        } else {
                            isValid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Month release must be from 1 to 12");
                    }
                    sc.nextLine();
                } while (isValid == false);
                list.add(new Magazine(idDocument, publisher, numOfRelease, seri, monRelease));
                break;
            case 3:
                isValid = false;
                do {
                    System.out.print("Enter date release (yyyy-MM-dd): ");
                    date = sc.nextLine().trim();
                    if (date.equals("")) {
                        System.out.println("Date can't be empty!");
                    }
                    if (!DateValidator.isDateValid(date)) {
                        System.out.println("Date is not valid! (yyyy-MM-dd)");
                    } else {
                        isValid = true;
                    }
                } while (isValid == false);
                String[] arr = date.split("-");
                date = arr[2] + "/" + arr[1] + "/" + arr[0];
                list.add(new Newspaper(idDocument, publisher, numOfRelease, date));
        }
        return true;
    }

    private boolean isExisted(int id) {
        for (Document d : this.list) {
            if (d.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteDocument(int id) {
        if (isExisted(id)) {
            for (Document d : this.list) {
                if (d.getId() == id) {
                    this.list.remove(id);
                    System.out.println("Delete successfully!");
                    return true;
                }
            }
            return false;
        } else {
            System.out.println("The id does not exist!");
            return false;
        }
    }

    public void showDocument() {
        if (list.isEmpty()) {
            System.out.println("There is no document in database!");
            return;
        }
        System.out.println("ID    | Publisher            | Number Release");
        for (Document d : list) {
            System.out.printf("%5d | %-20s | %d\n", d.getId(), d.getPublisher(), d.getNumberRelease());
        }
    }

    public void showByType(int choice) {
        switch (choice) {
            case 1:
                ArrayList<Book> listBooks = new ArrayList<>();
                for (Document d : list) {
                    if (d instanceof Book) {
                        listBooks.add((Book) d);
                    }
                }
                if (listBooks.isEmpty()) {
                    System.out.println("There is no book");
                    break;
                }
                System.out.println("ID    | Publisher            | Number of copy | Author               | Number Of Page");
                for (Book b : listBooks) {
                    System.out.printf("%5d | %-20s | %-14d | %-20s | %d\n", b.getId(), b.getPublisher(), b.getNumberRelease(), b.getAuthor(), b.getNumOfPage());
                }
                break;
            case 2:
                ArrayList<Magazine> listMagazine = new ArrayList<>();
                for (Document d : list) {
                    if (d instanceof Magazine) {
                        listMagazine.add((Magazine) d);
                    }
                }
                if (listMagazine.isEmpty()) {
                    System.out.println("There is not Magazine");
                    break;
                }
                System.out.println("ID    | Publisher            | Number of copy | Publish Number | Month");
                for (Magazine m : listMagazine) {
                    System.out.printf("%5d | %-20s | %-14d | %14d | %d\n", m.getId(), m.getPublisher(), m.getNumberRelease(), m.getPublishNum(), m.getPublishMon());
                }
                break;
            case 3:
                ArrayList<Newspaper> listNewspaper = new ArrayList<>();
                for (Document d : list) {
                    if (d instanceof Newspaper) {
                        listNewspaper.add((Newspaper) d);
                    }
                }
                if (listNewspaper.isEmpty()) {
                    System.out.println("There is no newspaper");
                    break;
                }
                System.out.println("ID    | Publisher            | Number of copy | Date");
                for (Newspaper n : listNewspaper) {
                    System.out.printf("%5d | %-20s | %-14d | %s\n", n.getId(), n.getPublisher(), n.getNumberRelease(), n.getDate());
                }
        }
    }

    public void callMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean isLoop = true, isValid = false;

        do {
            System.out.println("- - - - Book Management - - - -");
            System.out.println("1. Add a new document");
            System.out.println("2. Delete a document");
            System.out.println("3. Show document");
            System.out.println("4. Search by type");
            System.out.println("5. Exit");
            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    if (choice > 5 || choice < 1) {
                        System.out.println("Choice must be from 1 to 5!");
                    } else {
                        isValid = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Choice must be from 1 to 5!");
                }
                sc.nextLine();
            } while (isValid == false);
            switch (choice) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    System.out.println("- - - - Delete Document - - - -");
                    isValid = false;
                    int id = 0;
                    do {
                        try {
                            System.out.print("Enter the id document delete: ");
                            id = sc.nextInt();
                            if (id < 0) {
                                System.out.println("The id must be a positive number!");
                            } else {
                                isValid = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("The id must be a positive number!");
                        }
                        sc.nextLine();
                    } while (isValid == false);
                    deleteDocument(id);
                    break;
                case 3:
                    System.out.println("- - - - Show Document - - - -");
                    showDocument();
                    break;
                case 4:
                    System.out.println("- - - - Search By Type - - - -");
                    this.showByType(chooseDocument());
                    break;
                case 5:
                    System.out.println("Thanks for using software!");
                    System.out.println("See you later");
                    isLoop = false;
                    break;
            }
        } while (isLoop);
    }
}
