package org.example.repositories.Jooq;

import lombok.RequiredArgsConstructor;
import org.example.repositories.jooqGenEntities.tables.Cat;
import org.example.repositories.jooqGenEntities.tables.records.CatRecord;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository*/
@RequiredArgsConstructor
public class JooqCatRepository {
    private final DSLContext context;
    private final Cat cat = Cat.CAT;

    public @Nullable CatRecord add(org.example.repositories.jooqGenEntities.tables.pojos.Cat cat1) {
        return context.insertInto(cat)
                .columns(cat.BIRTH_DATE, cat.BREED, cat.COLOR, cat.OWNER_ID)
                .values(cat1.getBirthDate(), cat1.getBreed(), cat1.getColor(), cat1.getOwnerId())
                .returning()
                .fetchOne();
    }

    public @Nullable CatRecord update(org.example.repositories.jooqGenEntities.tables.pojos.Cat cat1) {
        return context.update(cat)
                .set(cat.BIRTH_DATE, cat1.getBirthDate())
                .set(cat.BREED, cat1.getBreed())
                .set(cat.COLOR, cat1.getColor())
                .set(cat.OWNER_ID, cat1.getOwnerId())
                .where(cat.CAT_ID.eq(cat1.getCatId()))
                .returning()
                .fetchOne();
    }

    public @Nullable CatRecord findById(Long id) {
        return context.selectFrom(cat)
                .where(cat.CAT_ID.eq(id))
                .fetchOne();

    }

    public List<CatRecord> findAll() {
        return context.selectFrom(cat)
                .stream().toList();
    }

    public @Nullable CatRecord delete(Long id) {
        return context.delete(cat)
                .where(cat.CAT_ID.eq(id))
                .returning()
                .fetchOne();
    }
}
