package org.example.repositories.Jooq;

import lombok.RequiredArgsConstructor;
import org.example.repositories.jooqGenEntities.tables.Owner;
import org.example.repositories.jooqGenEntities.tables.records.OwnerRecord;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository*/
@RequiredArgsConstructor
public class JooqOwnerRepository {
    private final DSLContext context;
    private final Owner owner = Owner.OWNER;

    public @Nullable OwnerRecord add(org.example.repositories.jooqGenEntities.tables.pojos.Owner owner1) {
        return context.insertInto(owner)
                .columns(owner.BIRTH_DATE)
                .values(owner1.getBirthDate())
                .returning()
                .fetchOne();
    }

    public @Nullable OwnerRecord update(org.example.repositories.jooqGenEntities.tables.pojos.Owner owner1) {
        return context.update(owner)
                .set(owner.BIRTH_DATE, owner1.getBirthDate())
                .where(owner.OWNER_ID.eq(owner1.getOwnerId()))
                .returning()
                .fetchOne();
    }

    public @Nullable OwnerRecord findById(Long id) {
        return context.selectFrom(owner)
                .where(owner.OWNER_ID.eq(id))
                .fetchOne();
    }

    public List<OwnerRecord> findAll() {
        return context.selectFrom(owner)
                .stream().toList();
    }

    public OwnerRecord delete(Long id) {
        return context.delete(owner)
                .where(owner.OWNER_ID.eq(id))
                .returning()
                .fetchOne();
    }
}
