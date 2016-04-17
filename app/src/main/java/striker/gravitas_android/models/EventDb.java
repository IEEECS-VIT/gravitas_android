package striker.gravitas_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by striker on 2/17/16.
 */
public class EventDb extends RealmObject {

    @Expose
    @PrimaryKey
    @SerializedName("_id")
    private String _id;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("coordinators")
    private RealmList<Coordinators> coordinators;

    @Expose
    @SerializedName("faculty")
    private Faculty faculty;

    @Expose
    @SerializedName("event")
    private Event event;

    @Expose
    @SerializedName("finance")
    private Finance finance;

    @Expose
    @SerializedName("guest")
    private RealmList<Guest> guest;

    @Expose
    @SerializedName("team")
    private int team;

    @Expose
    @SerializedName("miscellaneous")
    private String miscellaneous;

    @Expose
    @SerializedName("remarks")
    private String remarks;

    public EventDb(String id, String status, RealmList<Coordinators> coordinators, Faculty faculty, Event event, Finance finance, RealmList<Guest> guest, int team, String miscellaneous, String remarks) {
        _id = id;
        this.status = status;
        this.coordinators = coordinators;
        this.faculty = faculty;
        this.event = event;
        this.finance = finance;
        this.guest = guest;
        this.team = team;
        this.miscellaneous = miscellaneous;
        this.remarks = remarks;
    }
}

class Coordinators extends RealmObject {

    @Expose
    @SerializedName("reg_no")
    private String reg_no;

    @Expose
    @SerializedName("phone_no")
    private String phone_no;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("room")
    private String room;

    Coordinators(String reg_no, String phone_no, String name, String email, String room) {
        this.reg_no = reg_no;
        this.phone_no = phone_no;
        this.name = name;
        this.email = email;
        this.room = room;
    }
}

class Faculty extends RealmObject {

    @Expose
    @SerializedName("faculty_id")
    private String faculty_id;

    @Expose
    @SerializedName("phone_no")
    private String phone_no;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("room")
    private String room;

    Faculty(String faculty_id, String phone_no, String name, String email, String room) {
        this.faculty_id = faculty_id;
        this.phone_no = phone_no;
        this.name = name;
        this.email = email;
        this.room = room;
    }
}

class Event extends RealmObject {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("org")
    private String org;

    @Expose
    @SerializedName("schedule")
    private Schedule schedule;

    @Expose
    @SerializedName("summary")
    private String summary;

    @Expose
    @SerializedName("page")
    private String page;

    @Expose
    @SerializedName("description")
    private String description;

    Event(String name, String type, String org, Schedule schedule, String summary, String page, String description) {
        this.name = name;
        this.type = type;
        this.org = org;
        this.schedule = schedule;
        this.summary = summary;
        this.page = page;
        this.description = description;
    }
}

class Finance extends RealmObject {

    @Expose
    @SerializedName("fees")
    private int fees;

    @Expose
    @SerializedName("prize")
    private Prize prize;

    @Expose
    @SerializedName("sponsorship")
    private Sponsorship sponsorship;

    @Expose
    @SerializedName("registrations")
    private Registrations registrations;

    @Expose
    @SerializedName("income")
    private int income;

    @Expose
    @SerializedName("budget")
    private Budget budget;

    @Expose
    @SerializedName("expenditure")
    private int expenditure;

    @Expose
    @SerializedName("profit")
    private int profit;

    Finance(int fees, Prize prize, Sponsorship sponsorship, Registrations registrations, int income, Budget budget, int expenditure, int profit) {
        this.fees = fees;
        this.prize = prize;
        this.sponsorship = sponsorship;
        this.registrations = registrations;
        this.income = income;
        this.budget = budget;
        this.expenditure = expenditure;
        this.profit = profit;
    }
}

class Guest extends RealmObject {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("travel")
    private Travel travel;

    @Expose
    @SerializedName("stay")
    private Stay stay;

    @Expose
    @SerializedName("food")
    private Food food;

    Guest(String name, Travel travel, Stay stay, Food food) {
        this.name = name;
        this.travel = travel;
        this.stay = stay;
        this.food = food;
    }
}

class Schedule extends RealmObject {


    @Expose
    @SerializedName("venue")
    private String venue;

    @Expose
    @SerializedName("date")
    private String date;

    @Expose
    @SerializedName("time")
    private String time;

    Schedule(String venue, String date, String time) {
        this.venue = venue;
        this.date = date;
        this.time = time;
    }
}

class Prize extends RealmObject {

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("breakdown")
    private int[] breakdown;

    Prize(int total, int[] breakdown) {
        this.total = total;
        this.breakdown = breakdown;
    }
}

class Sponsorship extends RealmObject {

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("breakdown")
    private RealmList<Breakdown> breakdown;

    Sponsorship(int total, RealmList<Breakdown> breakdown) {
        this.total = total;
        this.breakdown = breakdown;
    }
}

class Registrations extends RealmObject {


    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("current")
    private String current;

    @Expose
    @SerializedName("individual")
    private String individual;

    @Expose
    @SerializedName("combos")
    private Combos combos;

    Registrations(int total, String current, String individual, Combos combos) {
        this.total = total;
        this.current = current;
        this.individual = individual;
        this.combos = combos;
    }
}

class Budget extends RealmObject {

    @Expose
    @SerializedName("mementos")
    private Mementos mementos;

    @Expose
    @SerializedName("purchase")
    private RealmList<Purchase> purchase;

    @Expose
    @SerializedName("tags")
    private Tags tags;

    @Expose
    @SerializedName("certificates")
    private Certificates certificates;

    @Expose
    @SerializedName("travel")
    private int travel;

    @Expose
    @SerializedName("food")
    private int food;

    @Expose
    @SerializedName("stay")
    private int stay;

    Budget(Mementos mementos, RealmList<Purchase> purchase, Tags tags, Certificates certificates, int travel, int food, int stay) {
        this.mementos = mementos;
        this.purchase = purchase;
        this.tags = tags;
        this.certificates = certificates;
        this.travel = travel;
        this.food = food;
        this.stay = stay;
    }
}

class Travel extends RealmObject {

    @Expose
    @SerializedName("amount")
    private int amount;

    @Expose
    @SerializedName("from")
    private String from;

    Travel(int amount, String from) {
        this.amount = amount;
        this.from = from;
    }
}

class Stay extends RealmObject {

    @Expose
    @SerializedName("duration")
    private int duration;

    Stay(int duration) {
        this.duration = duration;
    }
}

class Food extends RealmObject {

    @Expose
    @SerializedName("units")
    private int units;

    Food(int units) {
        this.units = units;
    }
}

class Breakdown extends RealmObject {

    @Expose
    @SerializedName("source")
    private String source;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("amount")
    private int amount;


    Breakdown(String source, String type, int amount) {
        this.source = source;
        this.type = type;
        this.amount = amount;
    }
}

class Combos extends RealmObject {

    @Expose
    @SerializedName("overall")
    private int overall;

    @Expose
    @SerializedName("breakdown")
    private int[] breakdown;

    Combos(int overall, int[] breakdown) {
        this.overall = overall;
        this.breakdown = breakdown;
    }
}

class Mementos extends RealmObject {

    @Expose
    @SerializedName("units")
    private int units;

    @Expose
    @SerializedName("costs")
    private int costs;

    Mementos(int units, int costs) {
        this.units = units;
        this.costs = costs;
    }
}

class Purchase extends RealmObject {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("quantity")
    private String quantity;

    @Expose
    @SerializedName("cost")
    private int cost;

    Purchase(String id, String quantity, int cost) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
    }
}

class Tags extends RealmObject {

    @Expose
    @SerializedName("units")
    private int units;

    @Expose
    @SerializedName("cost")
    private int cost;

    Tags(int units, int cost) {
        this.units = units;
        this.cost = cost;
    }
}

class Certificates extends RealmObject {


    @Expose
    @SerializedName("coordinator")
    private int coordinator;

    @Expose
    @SerializedName("participant")
    private int participant;

    @Expose
    @SerializedName("cost")
    private int cost;

    @Expose
    @SerializedName("winner")
    private int winner;

    @Expose
    @SerializedName("total")
    private int total;

    Certificates(int coordinator, int participant, int cost, int winner, int total) {
        this.coordinator = coordinator;
        this.participant = participant;
        this.cost = cost;
        this.winner = winner;
        this.total = total;
    }
}