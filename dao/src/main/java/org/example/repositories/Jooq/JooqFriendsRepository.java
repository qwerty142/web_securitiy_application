package org.example.repositories.Jooq;

import lombok.RequiredArgsConstructor;
import org.example.repositories.jooqGenEntities.tables.CatCat;
import org.example.repositories.jooqGenEntities.tables.records.CatCatRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/*@Repository*/
@RequiredArgsConstructor
public class JooqFriendsRepository {
    private final DSLContext context;
    private final CatCat catCat = CatCat.CAT_CAT;

    public CatCatRecord add(org.example.repositories.jooqGenEntities.tables.pojos.CatCat cat) {
        return context.insertInto(catCat)
                .columns(catCat.CAT1_ID, catCat.CAT2_ID)
                .values(cat.getCat1Id(), cat.getCat2Id())
                .returning()
                .fetchOne();
    }

    public CatCatRecord update(org.example.repositories.jooqGenEntities.tables.pojos.CatCat cat) {
        return context.update(catCat)
                .set(catCat.CAT1_ID, cat.getCat1Id())
                .set(catCat.CAT2_ID, cat.getCat2Id())
                .returning()
                .fetchOne();
    }
}
