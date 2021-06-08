package com.codecool.league.model.championsListTest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    public void setChampions(List<ChampionModel> champions) {
        this.champions = champions;
    }

    @SerializedName(value = "champion", alternate = {"Aatrox", "Ekko", "Jinx",
            "MissFortune", "Shen", "Varus",
            "Ahri", "Elise", "Kalista", "Mordekaiser", "Shyvana", "Vayne",
            "Akali", "Evelynn", "Karma", "Morgana", "Singed", "Veigar",
            "Alistar", "Ezreal", "Karthus", "Nami", "Sion", "Velkoz",
            "Amumu", "Fiddlesticks", "Kassadin", "Nasus", "Sivir", "Vi",
            "Anivia", "Fiora", "Katarina", "Nautilus", "Skarner", "Viktor",
            "Annie", "Fizz", "Kayle", "Nidalee", "Sona", "Vladimir",
            "Ashe", "Galio", "Kennen", "Nocturne", "Soraka", "Volibear",
            "AurelionSol", "Gangplank", "Khazix", "Nunu", "Swain", "Warwick",
            "Azir", "Garen", "Kindred", "Olaf", "Syndra", "MonkeyKing",
            "Bard", "Gnar", "Kled", "Orianna", "TahmKench", "Xerath",
            "Blitzcrank", "Gragas", "KogMaw", "Pantheon", "Taliyah", "XinZhao",
            "Brand", "Graves", "LeBlanc", "Poppy", "Talon", "Yasuo",
            "Braum", "Hecarim", "LeeSin", "Quinn", "Taric", "Yorick",
            "Caitlyn", "Heimerdinger", "Leona", "Rammus", "Teemo", "Zac",
            "Camille", "Illaoi", "Lissandra", "RekSai", "Thresh", "Zed",
            "Cassiopeia", "Irelia", "Lucian", "Renekton", "Tristana", "Ziggs",
            "Chogath", "Ivern", "Lulu", "Rengar", "Trundle", "Zilean",
            "Corki", "Janna", "Lux", "Riven", "Tryndamere", "Zyra",
            "Darius", "JarvanIV", "Malphite", "Rumble", "TwistedFate",
            "Diana", "Jax", "Malzahar", "Ryze", "Twitch",
            "DrMundo", "Jayce", "Maokai", "Sejuani", "Udyr",
            "Draven", "Jhin", "MasterYi", "Shaco", "Urgot", "Kaisa"})
    private List<ChampionModel> champions;

    public List<ChampionModel> getChampions() {
        return champions;
    }

    @Override
    public String toString() {
        return "Data{" +
                "champions=" + champions +
                '}';
    }
}