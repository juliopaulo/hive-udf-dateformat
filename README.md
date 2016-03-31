# hive-udf-dateformat

This example was tested in CDH 5 

# Step 1 
add jar  /home/cloudera/workspace/wkHiveUdf/hive-udf-dateformat/target/hive-udf-dateformat-1.0-SNAPSHOT.jar

# Step 2 
hive> CREATE TEMPORARY FUNCTION dateformat_custom AS 'com.hive.udf.DateFormat' ;

# Step 3 

 select dateformat_custom(substr(creation_date,1,19)) from social_account limit 10;
 
 
# Result final

03/18/15
03/19/15
04/03/15
05/29/15
06/04/15
06/04/15
06/05/15
06/06/15
06/06/15
06/06/15
Time taken: 0.26 seconds, Fetched: 10 row(s)
hive> 

