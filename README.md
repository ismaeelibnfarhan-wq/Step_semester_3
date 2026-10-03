### Date:
October 3, 2026

### Today's Works:
- **Implemented Week 8 Category C Class (Practice) Problems in Java:**
  - `Problem1.java`: Modeled polymorphic payment fee processing for Card (2%), Wallet (1%), and Bank Transfer (0%) transactions.
  - `Problem2.java`: Built library item due date calculator using `LocalDate` for Books (14 days), DVDs (7 days), and Magazines (3 days).
  - `Problem3.java`: Created delivery fee calculation hierarchy for Standard, Express, and International shipping methods.
  - `Problem4.java`: Implemented question grading logic for MCQ (exact match), True/False (case-insensitive match), and Essay (keyword detection scoring).
  - `Problem5.java`: Developed public transport fare calculator supporting Bus (capped fare), Train, and Metro (peak hour multiplier).

- **Implemented Week 8 Category C Assignment Problems in Java:**
  - `Problem1.java`: Designed canteen billing system with customer pricing rules for Students (10% discount), Staff (5% discount), and Guests (service charge).
  - `Problem2.java`: Built campus parking fee calculator with tiered vehicle charging for Bikes, Cars, and Trucks.
  - `Problem3.java`: Modeled room electricity billing supporting Single, Shared (split across occupants), and AC rooms.
  - `Problem4.java`: Implemented employee festival bonus calculation for Full-Time, Part-Time, and Intern positions.
  - `Problem5.java`: Created subscription renewal tracker using `LocalDate` date addition across Basic (30 days), Standard (90 days), and Premium (365 days) plans.

- **Structure & Repository Management:**
  - Organized questions into separate files across designated `class/` and `assignment/` directories.
  - Maintained pure source files (`.java`) without generating or committing compiled `.class` binaries.

### Issues Faced:
- **Delivery Fee Pricing Alignment (Practice Problem 3):** Reconciling the sample test output with base fee specifications required accounting for additive base fees across the inheritance hierarchy rather than isolated standalone rates.
- **Quoted Input Parsing (Practice Problem 4):** Standard space-delimited input tokens broke on multi-word question texts, answers, and comma-separated keyword lists; resolved by using regular expression tokenization to correctly extract quoted string parameters.
- **Drive MIME Type Mapping:** Preventing cloud file uploads from auto-converting raw Java source files into formatted document files by enforcing `text/x-java` encoding.