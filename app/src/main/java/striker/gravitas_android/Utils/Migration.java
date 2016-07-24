package striker.gravitas_android.Utils;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;


/**
 * Created by striker on 2/19/16.
 */
public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
      /*  RealmSchema schema = realm.getSchema();
        RealmObjectSchema realmObjectSchema = schema.get("UserDataList");
        realmObjectSchema.setNullable("k",false);
        RealmObjectSchema realmObjectSchema1 = schema.get("...");
        realmObjectSchema1.setNullable("mid",false);*/
        oldVersion++;
    }
}
