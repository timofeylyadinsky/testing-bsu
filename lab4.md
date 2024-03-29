# _Test-cases_
---
*Web-site link:* [Casio](https://www.casio.com/us/ "Casio")

---

## 1. Add watches to basket


***Preconditions:*** 

Opened page with watches

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Click on block with picture and name of watches CASIO MW610H-1AV | Product page is opened |
| 2 | Click button _Buy Now_   | Checkout page is opened. In _Order Summary_ we see watches and it costs and total. Watches added to basket. |


## 2. Add second product (piano) to basket


***Preconditions:*** 

Opened page with Musical Instrument, one product in basket(first test complete successful) 

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Click on block with picture and name of piano Casiotone CT-S200BK | Product page is opened |
| 2 | Click button _Buy Now_   | Checkout page is opened. In _Order Summary_ we see all products(watches and piano) and their costs and total. Icons of cart have circle with number 2. Piano added to basket. |


## 3. Edit your cart (delete products from it)


***Preconditions:*** 

Opened Main page of site, two products(watches and piano) in basket(first and second test complete successful) 

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Click on icon of cart | Cart page is opened. In _Summary_ block we see costs of two products |
| 2 | Click _trash_ icon under first product (watches)   | Page information updated. Icons of cart in top have number 1. Only one Product in basket(piano). Updated _Summary_ information |
| 3 | Click _trash_ icon under second product (piano)  | Page information updated. Icons of cart in top have number 0. There are no product. In this block we see only one message _"You have no items in your shopping cart."_. |


## 4. Check searching


***Preconditions:*** 

Opened Main page of site

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | on main page in search bar input text "asdsasdasd" | Search-result page is opened. We see next text "Your search - asdsasdasd - did not match any answers we have." |
| 2 | on main page in search bar input text "Calculators"   | Search-result page is opened. Opened list of calculators |


## 5. Check favourite list


***Preconditions:*** 

Casio watches-classic page is opened

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | On opened page click in block of watches "Casio w218HC-AV" on "heart" icon | Color of this icon is change to black |
| 2 | In navigation click button of favourite   | Favourites page is opened. There are title of category of product and added product(watches) |

 
## 6. Check comparing

***Preconditions:*** 

Favourites page is opened, two products(watches) add to favourite

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Make checkboxes under product true | Checkboxes are choose. Button compare watches items is available |
| 2 | Click "Compare watches items" button   | Compare page is opened. Choosen product are in it? and their characteristics compared. |


## 7. Check filter of watches

***Preconditions:*** 

Watches Casio page is opened

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Open filter article | In Right side showed filter block. |
| 2 | Choose in Black color and Analog display in settings. then Click button show  | In list shown only black analog watches. |
| 3 | Open filter artice and clear all filters | List returned to initial variant |


## 8. Check Sorting in Filters

***Preconditions:*** 

Watches Casio page is opened. opened filter article

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | CLick _Price:High-Low_ button and Show button | Watches sorted by it price, from high price to low |
| 2 | Click _Price:Low-High_ button and Show button | Watches sorted by it price, from low price to high |
| 3 | Click _Weight:Heavy-Light_ button and Show button | Watches sorted by it weight, from Heavy price to Light |
| 4 | Click _Weight:Light-Heavy_ button and Show button | Watches sorted by it weight, from Light price to Heavy |
| 5 | Click _Newest_ button and Show button | List sort returned to initial variant |


## 9. Change location

***Preconditions:*** 

Main page is opened. Base location is USA

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | In footer click _United States_ button | Select Loacation page is opened |
| 2 | Choose _English(UK&Ireland)_ location | Opened _UK location_ version of site |


## 10. View of musical instrumental page

***Preconditions:*** 

Main page is opened

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | In navigation panel move cursor to _Electronic musical instruments_ and Click _ALL ELECTRONIC MUSICAL INSTRUMENTS_ | Opened page with list of product(musical instruments, f.e. piano) |


## 11. Check help-bot

***Preconditions:*** 

Main page is opened

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | In right-bottom side click _Help_ | Opened frame with Casio-bot |
| 2 | Print "test" and press _Enter_  | Bot send 3 articles which connected with word "test" |

## 12. Find manuals

***Preconditions:*** 

Manuals(Support) page is opened

***Test steps:***

| № |  Step Description   |  Expected Result  |
|---|------------------------|-------------------|
| 1 | Choose type of item(Timepieces (Watches)) and click it | Opened page with languages choose |
| 2 | Choose _English_ language and click it  | Opened page with watch manual archives |
| 3 | In _Module No._ form write "_593_" and click search  | Opened page with list of finding manuals in pdf format |
| 4 | Click _Module No. 593_ | Opened _.pdf_ file with manual |

