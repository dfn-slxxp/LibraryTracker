# LibraryTracker
LibraryTracker-an app to keep track of and organize resources in Libraries. Built using skills needed for the AP CS A exam.

## About Me
I'm Sebastian Waldman, Currently in Ms. Mouzakitis's Period 6 Annual Intro to CS class.

## Features
* Import important items commonly located in libraries via a CSV file
* Import members of a library via a CSV file
* Import each member's checkouts via a CSV file
* Sorts Data by...
    * Items checked out longest
    * Items due soonest

## Getting Started with LibraryTracker

### Cloning the Repository
Clone this repository by running the following: 
```bash
git clone https://github.com/dfn-slxxp/LibraryTracker.git
```

### CSV Input Formats
For this tool, you will need 3 CSV files.

#### Items.csv

This file must be formatted in the following way (examples provided per type):
```CSV
Type,Item Id,Name/Title,Author (only for Books), Type(Device + Disk)/Genre(Book)/Publisher(Newspaper)
Book,1,Shatter Me,Tahereh Mafi,Fantasy
Device,2,Lenovo Laptop,,Laptop
Newspaper,7,Before the Glow Fades: Figure Skating as Art,,NYT
Disk,6,KPOP Demon Hunters Soundtrack,,CD
```

* `Type`: The Type of Item: Book, Device, Newspaper, or Disk
* `Item Id`: *Unique* Item ID number. Cannot be the same as another item
* `Name`: Name or Title of the Item
* `Author`: This field is only for books. Name of Author
* `Misc Info`:
    * For Books: Genre: "Fantasy", "Realistic", "Nonfiction", "Other"
    * For Devices: Type: "Laptop", "IPad", "Desktop", "Other"
    * For Disks: Type: "CD", "DVD", "Bluray", "Other"
    * For Newspapers: Publisher: "NYT", "LAT", "WSJ", "USA Today", "Washington Post", "Other"

#### Members.csv

This file must be formatted in the following way (examples provided)
```CSV
ID,Name
0,Sebastian Waldman
1,Daniel Manita
5,Lucas Ou
```

* `ID`: *Unique* Member ID. Cannot be repeated for multiple users.
* `Name`: Name of the Member

#### Checkouts.csv

This file must be formatted in the following way (examples provided)
```CSV
Member ID,Item ID,Checkout Date
4,1,20260101
4,2,20251228
```

* `Member ID`: Member ID, same one used in Members.csv
* `Item ID`: Item ID, same one used in Items.csv
* `Checkout Date`: Date of Checkout, in YYYYMMDD format. For example, 1/28/2026 would be 20260128


### Building the Application
In the directory of the project, run
```bash
./gradlew build
```

### Running the Application with Gradle (Reccomended)

1. In the directory of the project, run
    ```bash
    ./gradlew run
    ```

2. You will then be prompted to enter File Paths to your CSV files. The files will default to the test files in "app/src/main/resources".