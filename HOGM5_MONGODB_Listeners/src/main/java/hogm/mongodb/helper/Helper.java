package hogm.mongodb.helper;

import java.time.LocalDate;

/**
 *
 * @author Anghel Leonard
 */
public final class Helper {

    public static final transient String[] NAMES = {"Djokovic", "Federer", "Murray", "Nadal",
        "Ferrer", "Berdych", "Del Potro", "Tsonga", "Tipsarevic", "Gasquet"};

    public static final transient String[] SURNAMES = {"Novak", "Roger", "Andy", "Rafael",
        "David", "Tomas", "Juan Martin", "Jo-Wilfried", "Janko", "Richard"};

    public static final transient int[] AGES = {25, 31, 25, 26, 30, 27, 24, 27, 28, 26};

    public static final transient LocalDate[] BIRTHS = {LocalDate.parse("1987-05-22"), LocalDate.parse("1981-08-08"),
        LocalDate.parse("1987-05-15"), LocalDate.parse("1986-06-03"), LocalDate.parse("1982-04-02"),
        LocalDate.parse("1985-09-17"), LocalDate.parse("1988-09-23"), LocalDate.parse("1985-04-17"),
        LocalDate.parse("1984-06-22"), LocalDate.parse("1986-06-18")};

    public static final transient String[] BIRTHPLACES = {"Belgrade, Serbia",
        "Basel, Switzerland", "Dunblane, Scotland", "Manacor, Mallorca, Spain", "Javea, Spain",
        "Valasske Mezirici, Czech", "Tandil, Argentina", "Le Mans, France", "Belgrade, Serbia", "Beziers, France"};

    public static final transient String[] RESIDENCES = {"Monte Carlo, Monaco", "Bottmingen, Switzerland",
        "London, England", "Manacor, Mallorca, Spain", "Valencia, Spain", "Monte Carlo, Monaco",
        "Tandil, Argentina", "Gingins, Switzerland", "Belgrade, Serbia", "Neuchatel, Switzerland"};

    public static final transient String[] HEIGHTS = {"188 cm", "185 cm", "190 cm", "185 cm", "175 cm",
        "196 cm", "198 cm", "188 cm", "180 cm", "185 cm"};

    public static final transient String[] WEIGHTS = {"176 lbs (80 kg)", "187 lbs (85 kg)", "185 lbs (84 kg)",
        "188 lbs (85 kg)", "160 lbs (73 kg)", "200 lbs (91 kg)", "214 lbs (97 kg)", "200 lbs (91 kg)",
        "176 lbs (80 kg)", "165 lbs (75 kg)"};

    public static final transient String[] PLAYS = {"Right-handed", "Right-handed", "Right-handed",
        "Left-handed", "Right-handed", "Right-handed", "Right-handed", "Right-handed", "Right-handed",
        "Right-handed"};

    public static final transient int[] TURNEDPRO = {2003, 1998, 2005, 2001, 2000, 2002, 2005, 2004, 2002, 2002};

    public static final transient String[] COACHS = {"Marian Vajda", "Paul Annacone", "Ivan Lendl",
        "Toni Nadal", "Javier Piles", "Tomas Krupa", "Franco Davin", "Roger Rasheed", "none",
        "Piatti, Grosjean"};

    public static final transient String[] WEBSITES = {"http://www.novakdjokovic.com",
        "http://www.rogerfederer.com", "http://www.andymurray.com", "http://www.rafaelnadal.com",
        "http://www.davidferrer.com", "http://tomasberdych.cz", "none", "none", "http://www.jtipsarevic.com",
        "http://richardgasquet.net"};

    public static final transient int[] RANKINS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static final transient String[] PRIZES = {"$45,686,497", "$76,014,777", "$24,934,421",
        "$50,061,827", "$17,178,869", "$13,139,293", "$10,853,349", "$10,676,927", "$6,600,238", "$7,540,613"};

    public static final transient String[] BNAMES = {"Rodriguez", "Wells", "Santana", "Teixeira", "Sabathia"};
    public static final transient String[] BSURNAMES = {"Alex", "Vernon", "Johan", "Mark", "CC"};
    public static final transient int[] BAGES = {37, 34, 33, 32, 32};
    public static final transient LocalDate[] BBIRTHS = {LocalDate.parse("1987-02-12"),
        LocalDate.parse("1981-01-02"), LocalDate.parse("1987-05-25"), LocalDate.parse("1986-09-03"), LocalDate.parse("1982-02-18")};
    public static final transient String[] BPOSITIONS = {"Third baseman / Shortstop", "Outfielder", "Starting pitcher", "First baseman", "Starting pitcher"};
}
