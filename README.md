This project is to have developers follow Mybatis Migration way to create SQL files for each release and
for deployers to migrate Matching Webservice database in Testing/Production.

## System prerequisites

The migration process requires Maven 3.0.x and Git to be able to work.
Check out http://maven.apache.org/download.cgi and http://git-scm.com/download/linux to install these packages if they are not existed

## As a developer, please follow these steps to create sql files

Checkout JavaWebIntroduction project

Create fresh database for the project in case you don't have one. This is for developers to recreate project database environment for development and debugging

* Ensure an Oracle user/schema has been created
* Update 'url', 'username' and 'password' properties in /src/main/resources/db/environments/development.properties.

```
$ mvn migration:bootstrap
```

Create your SQL files for your new feature or fix

```
$ mvn migration:new -Dmigration.description="your_description_goes_here"
```

A new SQL file named `<timestamp>_your_description_goes_here.sql` will be created in expense-manager/database/src/main/resources/myBatis/scripts folder.
Please follow instructions inside the script in order to create proper upgrade & downgrade scripts.
Please be noted that SQL script delimiter is `/` and is defined in `database/main/resources/myBatis/environments/*.properties`.

Update your local development database with SQL files created above

```
$ mvn migration:up
```

If you want to downgrade the last changes of the current database, run

```
$ mvn migration:down
```

## As a deployer, please follow these steps for database migration

Create fresh database for project in case you don't have one. This is for deployers to create a fresh project database environment for Testing or Production.

* Ensure an Oracle user/schema has been created
* Update 'url', 'username' and 'password' properties in `/src/main/resources/db/environments/<your-environment>.properties`. The '<your-environment>' is probably 'production' or 'testing'

```
$ mvn migration:bootstrap
```

Upgrade the current database for the release

```
$ mvn migration:up -Dmigration.env=<your-environment>
```

If you want to downgrade the last changes of the current database, run

```
$ mvn migration:down -Dmigration.env=<your-environment>
```


Please visit http://mybatis.googlecode.com/files/maven-migration-plugin-1.0.0-reference.pdf
