package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Heroes {
    String name;
    String url;


    static Map<String, String> toHeroes ()
    {
        Map <String, String> heroes = new HashMap<>();
        heroes.put("Abaddon", "https://www.dotabuff.com/heroes/abaddon/counters");
        heroes.put("Alchemist", "https://www.dotabuff.com/heroes/alchemist/counters");
        heroes.put("Ancient Apparition", "https://www.dotabuff.com/heroes/ancient-apparition/counters");
        heroes.put("Anti-Mage", "https://www.dotabuff.com/heroes/anti-mage/counters");
        heroes.put("Arc Warden", "https://www.dotabuff.com/heroes/arc-warden/counters");
        heroes.put("Axe", "https://www.dotabuff.com/heroes/axe/counters");
        heroes.put("Bane", "https://www.dotabuff.com/heroes/bane/counters");
        heroes.put("Batrider", "https://www.dotabuff.com/heroes/batrider/counters");
        heroes.put("Beastmaster", "https://www.dotabuff.com/heroes/beastmaster/counters");
        heroes.put("Bloodseeker", "https://www.dotabuff.com/heroes/bloodseeker/counters");
        heroes.put("Bounty Hunter", "https://www.dotabuff.com/heroes/bounty-hunter/counters");
        heroes.put("Brewmaster", "https://www.dotabuff.com/heroes/brewmaster/counters");
        heroes.put("Bristleback", "https://www.dotabuff.com/heroes/bristleback/counters");
        heroes.put("Broodmother", "https://www.dotabuff.com/heroes/broodmother/counters");
        heroes.put("Centaur Warrunner", "https://www.dotabuff.com/heroes/centaur-warrunner/counters");
        heroes.put("Chaos Knight", "https://www.dotabuff.com/heroes/chaos-knight/counters");
        heroes.put("Chen", "https://www.dotabuff.com/heroes/chen/counters");
        heroes.put("Clinkz", "https://www.dotabuff.com/heroes/clinkz/counters");
        heroes.put("Clockwerk", "https://www.dotabuff.com/heroes/clockwerk/counters");
        heroes.put("Crystal Maiden", "https://www.dotabuff.com/heroes/crystal-maiden/counters");
        heroes.put("Dark Seer", "https://www.dotabuff.com/heroes/dark-seer/counters");
        heroes.put("Dark Willow", "https://www.dotabuff.com/heroes/dark-willow/counters");
        heroes.put("Dawnbreaker", "https://www.dotabuff.com/heroes/dawnbreaker/counters");
        heroes.put("Dazzle", "https://www.dotabuff.com/heroes/dazzle/counters");
        heroes.put("Death Prophet", "https://www.dotabuff.com/heroes/death-prophet/counters");
        heroes.put("Disruptor", "https://www.dotabuff.com/heroes/disruptor/counters");
        heroes.put("Doom", "https://www.dotabuff.com/heroes/doom/counters");
        heroes.put("Dragon Knight", "https://www.dotabuff.com/heroes/dragon-knight/counters");
        heroes.put("Drow Ranger", "https://www.dotabuff.com/heroes/drow-ranger/counters");
        heroes.put("Earth Spirit", "https://www.dotabuff.com/heroes/earth-spirit/counters");
        heroes.put("Earthshaker", "https://www.dotabuff.com/heroes/earthshaker/counters");
        heroes.put("Elder Titan", "https://www.dotabuff.com/heroes/elder-titan/counters");
        heroes.put("Ember Spirit", "https://www.dotabuff.com/heroes/ember-spirit/counters");
        heroes.put("Enchantress", "https://www.dotabuff.com/heroes/enchantress/counters");
        heroes.put("Enigma", "https://www.dotabuff.com/heroes/enigma/counters");
        heroes.put("Faceless Void", "https://www.dotabuff.com/heroes/faceless-void/counters");
        heroes.put("Grimstroke", "https://www.dotabuff.com/heroes/grimstroke/counters");
        heroes.put("Gyrocopter", "https://www.dotabuff.com/heroes/gyrocopter/counters");
        heroes.put("Hoodwink", "https://www.dotabuff.com/heroes/hoodwink/counters");
        heroes.put("Huskar", "https://www.dotabuff.com/heroes/huskar/counters");
        heroes.put("Invoker", "https://www.dotabuff.com/heroes/invoker/counters");
        heroes.put("Io", "https://www.dotabuff.com/heroes/io/counters");
        heroes.put("Jakiro", "https://www.dotabuff.com/heroes/jakiro/counters");
        heroes.put("Juggernaut", "https://www.dotabuff.com/heroes/juggernaut/counters");
        heroes.put("Keeper of the Light", "https://www.dotabuff.com/heroes/keeper-of-the-light/counters");
        heroes.put("Kez", "https://www.dotabuff.com/heroes/kez/counters");
        heroes.put("Kunkka", "https://www.dotabuff.com/heroes/kunkka/counters");
        heroes.put("Legion Commander", "https://www.dotabuff.com/heroes/legion-commander/counters");
        heroes.put("Leshrac", "https://www.dotabuff.com/heroes/leshrac/counters");
        heroes.put("Lich", "https://www.dotabuff.com/heroes/lich/counters");
        heroes.put("Lifestealer", "https://www.dotabuff.com/heroes/lifestealer/counters");
        heroes.put("Lina", "https://www.dotabuff.com/heroes/lina/counters");
        heroes.put("Lion", "https://www.dotabuff.com/heroes/lion/counters");
        heroes.put("Lone Druid", "https://www.dotabuff.com/heroes/lone-druid/counters");
        heroes.put("Luna", "https://www.dotabuff.com/heroes/luna/counters");
        heroes.put("Lycan", "https://www.dotabuff.com/heroes/lycan/counters");
        heroes.put("Magnus", "https://www.dotabuff.com/heroes/magnus/counters");
        heroes.put("Marci", "https://www.dotabuff.com/heroes/marci/counters");
        heroes.put("Mars", "https://www.dotabuff.com/heroes/mars/counters");
        heroes.put("Medusa", "https://www.dotabuff.com/heroes/medusa/counters");
        heroes.put("Meepo", "https://www.dotabuff.com/heroes/meepo/counters");
        heroes.put("Mirana", "https://www.dotabuff.com/heroes/mirana/counters");
        heroes.put("Monkey King", "https://www.dotabuff.com/heroes/monkey-king/counters");
        heroes.put("Morphling", "https://www.dotabuff.com/heroes/morphling/counters");
        heroes.put("Muerta", "https://www.dotabuff.com/heroes/muerta/counters");
        heroes.put("Naga Siren", "https://www.dotabuff.com/heroes/naga-siren/counters");
        heroes.put("Nature's Prophet", "https://www.dotabuff.com/heroes/natures-prophet/counters");
        heroes.put("Necrophos", "https://www.dotabuff.com/heroes/necrophos/counters");
        heroes.put("Night Stalker", "https://www.dotabuff.com/heroes/night-stalker/counters");
        heroes.put("Nyx Assassin", "https://www.dotabuff.com/heroes/nyx-assassin/counters");
        heroes.put("Ogre Magi", "https://www.dotabuff.com/heroes/ogre-magi/counters");
        heroes.put("Omniknight", "https://www.dotabuff.com/heroes/omniknight/counters");
        heroes.put("Oracle", "https://www.dotabuff.com/heroes/oracle/counters");
        heroes.put("Outworld Destroyer", "https://www.dotabuff.com/heroes/outworld-destroyer/counters");
        heroes.put("Pangolier", "https://www.dotabuff.com/heroes/pangolier/counters");
        heroes.put("Phantom Assassin", "https://www.dotabuff.com/heroes/phantom-assassin/counters");
        heroes.put("Phantom Lancer", "https://www.dotabuff.com/heroes/phantom-lancer/counters");
        heroes.put("Phoenix", "https://www.dotabuff.com/heroes/phoenix/counters");
        heroes.put("Primal Beast", "https://www.dotabuff.com/heroes/primal-beast/counters");
        heroes.put("Puck", "https://www.dotabuff.com/heroes/puck/counters");
        heroes.put("Pudge", "https://www.dotabuff.com/heroes/pudge/counters");
        heroes.put("Pugna", "https://www.dotabuff.com/heroes/pugna/counters");
        heroes.put("Queen of Pain", "https://www.dotabuff.com/heroes/queen-of-pain/counters");
        heroes.put("Razor", "https://www.dotabuff.com/heroes/razor/counters");
        heroes.put("Riki", "https://www.dotabuff.com/heroes/riki/counters");
        heroes.put("Ringmaster", "https://www.dotabuff.com/heroes/ringmaster/counters");
        heroes.put("Rubick", "https://www.dotabuff.com/heroes/rubick/counters");
        heroes.put("Sand King", "https://www.dotabuff.com/heroes/sand-king/counters");
        heroes.put("Shadow Demon", "https://www.dotabuff.com/heroes/shadow-demon/counters");
        heroes.put("Shadow Fiend", "https://www.dotabuff.com/heroes/shadow-fiend/counters");
        heroes.put("Shadow Shaman", "https://www.dotabuff.com/heroes/shadow-shaman/counters");
        heroes.put("Silencer", "https://www.dotabuff.com/heroes/silencer/counters");
        heroes.put("Skywrath Mage", "https://www.dotabuff.com/heroes/skywrath-mage/counters");
        heroes.put("Slardar", "https://www.dotabuff.com/heroes/slardar/counters");
        heroes.put("Slark", "https://www.dotabuff.com/heroes/slark/counters");
        heroes.put("Snapfire", "https://www.dotabuff.com/heroes/snapfire/counters");
        heroes.put("Sniper", "https://www.dotabuff.com/heroes/sniper/counters");
        heroes.put("Spectre", "https://www.dotabuff.com/heroes/spectre/counters");
        heroes.put("Spirit Breaker", "https://www.dotabuff.com/heroes/spirit-breaker/counters");
        heroes.put("Storm Spirit", "https://www.dotabuff.com/heroes/storm-spirit/counters");
        heroes.put("Sven", "https://www.dotabuff.com/heroes/sven/counters");
        heroes.put("Techies", "https://www.dotabuff.com/heroes/techies/counters");
        heroes.put("Templar Assassin", "https://www.dotabuff.com/heroes/templar-assassin/counters");
        heroes.put("Terrorblade", "https://www.dotabuff.com/heroes/terrorblade/counters");
        heroes.put("Tidehunter", "https://www.dotabuff.com/heroes/tidehunter/counters");
        heroes.put("Timbersaw", "https://www.dotabuff.com/heroes/timbersaw/counters");
        heroes.put("Tinker", "https://www.dotabuff.com/heroes/tinker/counters");
        heroes.put("Tiny", "https://www.dotabuff.com/heroes/tiny/counters");
        heroes.put("Treant Protector", "https://www.dotabuff.com/heroes/treant-protector/counters");
        heroes.put("Troll Warlord", "https://www.dotabuff.com/heroes/troll-warlord/counters");
        heroes.put("Tusk", "https://www.dotabuff.com/heroes/tusk/counters");
        heroes.put("Underlord", "https://www.dotabuff.com/heroes/underlord/counters");
        heroes.put("Undying", "https://www.dotabuff.com/heroes/undying/counters");
        heroes.put("Ursa", "https://www.dotabuff.com/heroes/ursa/counters");
        heroes.put("Vengeful Spirit", "https://www.dotabuff.com/heroes/vengeful-spirit/counters");
        heroes.put("Venomancer", "https://www.dotabuff.com/heroes/venomancer/counters");
        heroes.put("Viper", "https://www.dotabuff.com/heroes/viper/counters");
        heroes.put("Visage", "https://www.dotabuff.com/heroes/visage/counters");
        heroes.put("Void Spirit", "https://www.dotabuff.com/heroes/void-spirit/counters");
        heroes.put("Warlock", "https://www.dotabuff.com/heroes/warlock/counters");
        heroes.put("Weaver", "https://www.dotabuff.com/heroes/weaver/counters");
        heroes.put("Windranger", "https://www.dotabuff.com/heroes/windranger/counters");
        heroes.put("Winter Wyvern", "https://www.dotabuff.com/heroes/winter-wyvern/counters");
        heroes.put("Witch Doctor", "https://www.dotabuff.com/heroes/witch-doctor/counters");
        heroes.put("Wraith King", "https://www.dotabuff.com/heroes/wraith-king/counters");
        heroes.put("Zeus", "https://www.dotabuff.com/heroes/zeus/counters");

        return heroes;
    }
}

/*
name - имя героя, по которому будет выбираться url
url - его страница контрпиков

125 героев
 */