create view movementView as

select  first.date_movement ,first.method_type ,first.quantity, 
        first.unit_price ,first.actual_price_stock ,first.family ,store_name 
        from 
        (select date_movement ,method_type,quantity,store_id ,unit_price ,actual_price_stock  
            , family 
            from movement 
            join articles 
            on articles.articlesid =articles_articlesid 
            order by date_movement
        ) 
        as first 
        join store 
        on store.id = first.store_id
;