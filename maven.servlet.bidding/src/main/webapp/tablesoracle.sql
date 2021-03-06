CREATE TABLE  "E_BIDDER" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(4000), 
	"POSTAL" VARCHAR2(4000), 
	"EMAIL" VARCHAR2(4000), 
	"MOBILE" NUMBER, 
	 CONSTRAINT "E_BIDDER_PK" PRIMARY KEY ("ID") ENABLE
   )
/
Note: ID must be generated through sequence in E_BIDDER table.

   /   
   CREATE TABLE  "E_PRODUCT" 
   (	"ITEMNO" VARCHAR2(4000), 
	"NAME" VARCHAR2(4000), 
	"QUANTITY" NUMBER, 
	"PRICE" NUMBER, 
	"SOLDOUT" NUMBER, 
	 CONSTRAINT "E_PRODUCT_PK" PRIMARY KEY ("ITEMNO") ENABLE
   )
/
CREATE TABLE  "E_BIDPRODUCT" 
   (	"ITEMNO" VARCHAR2(4000) NOT NULL ENABLE, 
	"NAME" VARCHAR2(4000) NOT NULL ENABLE, 
	"BIDPRICE" NUMBER,
	"BIDDERID" NUMBER,
	"BIDDATE" DATE, 
	"BIDDINGSTATUS" VARCHAR2(4000)
   )
/


