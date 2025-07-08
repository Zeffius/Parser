package main.parserDota;

import main.parserDota.DotabuffParsing.ParsingDotabuffTeam1;
import main.parserDota.DotabuffParsing.ParsingDotabuffTeam2;
import main.parserDota.Heroes.Heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareTeamsDotaManual{

    public static List<String> heroesTeamManual1 = new ArrayList<>();
    public static List <String> heroesTeamManual2 = new ArrayList <> ();

    public static void compareTeams() {
        Map<String, String> heroes = Heroes.toHeroes();
        createHeroes();
        ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte)0);
        System.out.println("________");
        ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte)0);
    }

    public static void createHeroes ()
    {

        String hero1Team1 = dark_seer;
        String hero2Team1 = earthshaker;
        String hero3Team1 = puck;
        String hero4Team1 = natures_prophet;
        String hero5Team1 = shadow_shaman;

        String hero1Team2 = pangolier;
        String hero2Team2 = shadow_fiend;
        String hero3Team2 = marci;
        String hero4Team2 = ursa;
        String hero5Team2 = tusk;


        heroesTeamManual1.add(hero1Team1);
        heroesTeamManual1.add(hero2Team1);
        heroesTeamManual1.add(hero3Team1);
        heroesTeamManual1.add(hero4Team1);
        heroesTeamManual1.add(hero5Team1);
        heroesTeamManual2.add(hero1Team2);
        heroesTeamManual2.add(hero2Team2);
        heroesTeamManual2.add(hero3Team2);
        heroesTeamManual2.add(hero4Team2);
        heroesTeamManual2.add(hero5Team2);


        /*
        String hero1Team1 = ;
        String hero2Team1 = ;
        String hero3Team1 = ;
        String hero4Team1 = ;
        String hero5Team1 = ;

        String hero1Team2 = ;
        String hero2Team2 = ;
        String hero3Team2 = ;
        String hero4Team2 = ;
        String hero5Team2 = ;


         */
    }



/*

https://www.youtube.com/watch?v=Bw26a9tW7G8&t=2129s
 */

    public static String abaddon = "Abaddon";
    public static String alchemist = "Alchemist";
    public static String ancient_apparition = "Ancient Apparition";
    public static String antimage = "Anti-Mage";
    public static String arc_warden = "Arc Warden";
    public static String axe = "Axe";
    public static String bane = "Bane";
    public static String batrider = "Batrider";
    public static String beastmaster = "Beastmaster";
    public static String bloodseeker = "Bloodseeker";
    public static String bounty_hunter = "Bounty Hunter";
    public static String brewmaster = "Brewmaster";
    public static String bristleback = "Bristleback";
    public static String broodmother = "Broodmother";
    public static String centaur_warrunner = "Centaur Warrunner";
    public static String chaos_knight = "Chaos Knight";
    public static String chen = "Chen";
    public static String clinkz = "Clinkz";
    public static String clockwerk = "Clockwerk";
    public static String crystal_maiden = "Crystal Maiden";
    public static String dark_seer = "Dark Seer";
    public static String dark_willow = "Dark Willow";
    public static String dawnbreaker = "Dawnbreaker";
    public static String dazzle = "Dazzle";
    public static String death_prophet = "Death Prophet";
    public static String disruptor = "Disruptor";
    public static String doom = "Doom";
    public static String dragon_knight = "Dragon Knight";
    public static String drow_ranger = "Drow Ranger";
    public static String earth_spirit = "Earth Spirit";
    public static String earthshaker = "Earthshaker";
    public static String elder_titan = "Elder Titan";
    public static String ember_spirit = "Ember Spirit";
    public static String enchantress = "Enchantress";
    public static String enigma = "Enigma";
    public static String faceless_void = "Faceless Void";
    public static String grimstroke = "Grimstroke";
    public static String gyrocopter = "Gyrocopter";
    public static String hoodwink = "Hoodwink";
    public static String huskar = "Huskar";
    public static String invoker = "Invoker";
    public static String io = "Io";
    public static String jakiro = "Jakiro";
    public static String juggernaut = "Juggernaut";
    public static String keeper_of_the_light = "Keeper of the Light";
    public static String kez = "Kez";
    public static String kunkka = "Kunkka";
    public static String legion_commander = "Legion Commander";
    public static String leshrac = "Leshrac";
    public static String lich = "Lich";
    public static String lifestealer = "Lifestealer";
    public static String lina = "Lina";
    public static String lion = "Lion";
    public static String lone_druid = "Lone Druid";
    public static String luna = "Luna";
    public static String lycan = "Lycan";
    public static String magnus = "Magnus";
    public static String marci = "Marci";
    public static String mars = "Mars";
    public static String medusa = "Medusa";
    public static String meepo = "Meepo";
    public static String mirana = "Mirana";
    public static String monkey_king = "Monkey King";
    public static String morphling = "Morphling";
    public static String muerta = "Muerta";
    public static String naga_siren = "Naga Siren";
    public static String natures_prophet = "Nature's Prophet";
    public static String necrophos = "Necrophos";
    public static String night_stalker = "Night Stalker";
    public static String nyx_assassin = "Nyx Assassin";
    public static String ogre_magi = "Ogre Magi";
    public static String omniknight = "Omniknight";
    public static String oracle = "Oracle";
    public static String outworld_destroyer = "Outworld Destroyer";
    public static String pangolier = "Pangolier";
    public static String phantom_assassin = "Phantom Assassin";
    public static String phantom_lancer = "Phantom Lancer";
    public static String phoenix = "Phoenix";
    public static String primal_beast = "Primal Beast";
    public static String puck = "Puck";
    public static String pudge = "Pudge";
    public static String pugna = "Pugna";
    public static String queen_of_pain = "Queen of Pain";
    public static String razor = "Razor";
    public static String riki = "Riki";
    public static String ringmaster = "Ringmaster";
    public static String rubick = "Rubick";
    public static String sand_king = "Sand King";
    public static String shadow_demon = "Shadow Demon";
    public static String shadow_fiend = "Shadow Fiend";
    public static String shadow_shaman = "Shadow Shaman";
    public static String silencer = "Silencer";
    public static String skywrath_mage = "Skywrath Mage";
    public static String slardar = "Slardar";
    public static String slark = "Slark";
    public static String snapfire = "Snapfire";
    public static String sniper = "Sniper";
    public static String spectre = "Spectre";
    public static String spirit_breaker = "Spirit Breaker";
    public static String storm_spirit = "Storm Spirit";
    public static String sven = "Sven";
    public static String techies = "Techies";
    public static String templar_assassin = "Templar Assassin";
    public static String terrorblade = "Terrorblade";
    public static String tidehunter = "Tidehunter";
    public static String timbersaw = "Timbersaw";
    public static String tinker = "Tinker";
    public static String tiny = "Tiny";
    public static String treant_protector = "Treant Protector";
    public static String troll_warlord = "Troll Warlord";
    public static String tusk = "Tusk";
    public static String underlord = "Underlord";
    public static String undying = "Undying";
    public static String ursa = "Ursa";
    public static String vengeful_spirit = "Vengeful Spirit";
    public static String venomancer = "Venomancer";
    public static String viper = "Viper";
    public static String visage = "Visage";
    public static String void_spirit = "Void Spirit";
    public static String warlock = "Warlock";
    public static String weaver = "Weaver";
    public static String windranger = "Windranger";
    public static String winter_wyvern = "Winter Wyvern";
    public static String witch_doctor = "Witch Doctor";
    public static String wraith_king = "Wraith King";
    public static String zeus = "Zeus";



//    @Override
//    public void CompareTeams() {
//        Map<String, String> heroes = Heroes.toHeroes();
//        createHeroes();
//        ParsingDotabuffTeam1.parsingDotabuff(heroes);
//        System.out.println("________");
//        ParsingDotabuffTeam2.parsingDotabuff(heroes);
//    }
}
