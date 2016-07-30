package striker.gravitas_android.Utils;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmSchema;


/**
 * Created by striker on 2/19/16.
 */
public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if (oldVersion == 1) {
            schema.create("Favourites")
                    .addField("name", String.class, FieldAttribute.PRIMARY_KEY)
                    .addField("category", String.class)
                    .addField("subCategory", String.class)
                    .addRealmListField("org", schema.get("Org"))
                    .addRealmListField("coordinators", schema.get("Coordinator"))
                    .addField("description", String.class)
                    .addField("teamSize", int.class)
                    .addField("participationFee", int.class);
        }
        oldVersion++;
    }
}
