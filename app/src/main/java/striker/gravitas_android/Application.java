package striker.gravitas_android;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import striker.gravitas_android.Utils.Migration;

/**
 * Created by root on 24/7/16.
 */
public class Application extends android.app.Application {

    public RealmConfiguration realmConfiguration;
    public Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        realmConfiguration = new RealmConfiguration.Builder(context).migration(new Migration()).schemaVersion(1).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
