select ingredients.name from ingredients inner join vendors on ingredients.vendorid=vendors.vendorid && vendors.companyname='Veggies_R_Us';


select ingredients.name from ingredients inner join vendors on ingredients.vendorid=vendors.vendorid && (vendors.companyname='Veggies_R_Us' || vendors.companyname='Spring Water Supply');


select avg(ingredients.unitprice) from ingredients inner join vendors on ingredients.vendorid=vendors.vendorid && vendors.companyname='Veggies_R_Us';
select avg(items.price) from items 
inner join madewith on items.itemid=madewith.itemid 
inner join ingredients on madewith.ingredientid=ingredients.ingredientid
inner join vendors on vendors.vendorid=ingredients.vendorid && vendors.companyname='Veggies_R_Us';




select name,inventory from ingredients
where inventory<(select avg(ingredients.inventory) from ingredients);




select companyname from vendors where vendors.referredby=(select vendorid from vendors where companyname='Veggies_R_Us') 
&& vendorid in (
select vendors.vendorid from vendors 
inner join ingredients on vendors.vendorid=ingredients.vendorid and ingredients.foodgroup='Milk');
