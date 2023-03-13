# JFXPlayerRatings

This is an application to (subjectively) rate player performances and track their form.

## Launch procedure

    -git clone https://github.com/Denis0550/JFXPlayerRatings
    -open with editor (IntelliJ)
    -open  MySQL Workbench
    -reconfigure the password and username for the database src/main/java .. HibernateUtil
    -in mysql launch the db dump script, located in: db/db_dump_jfxPlayerRatings.sql
    -launch the project

## How application works
    -after the match you set game week (number start from 1; there are 38 game weeks in a season)
    -set player last name
    -set player rating (on a scale from 1 being the worst to 10 being the best)
    -total 11 player and substituts (if there were any) get a rating
    -press "Set Fields" to check your set data 
    -press "Add to db" to add to the ratings data base.
    -after week 2 you can track player performance by setting the name and pressing "Load" button.
