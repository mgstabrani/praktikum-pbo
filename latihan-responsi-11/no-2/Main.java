interface Section {
    public void run();
}

public class Main {

    public static GhostPokemon gastly;
    public static FightingPokemon machop;
    public static NormalPokemon rattata;
    public static Pokemon bigboss;

    public static void PokemonVersus(Pokemon x, Pokemon y) {
        System.out.println(x.getName() + " vs " + y.getName());
    }

    public static void main(String[] args) {
        Section[] sections = new Section[4];
        sections[0] = new Section() {

            @Override
            public void run() {
                Pokemon a = new GhostPokemon();
                Pokemon b = new FightingPokemon();
                Pokemon c = new NormalPokemon();
                Pokemon d = new Pokemon();
                System.out.println(a.getName());
                System.out.println(b.getName());
                System.out.println(c.getName());
                System.out.println(d.getName());

                gastly = new GhostPokemon("Gastly");
                machop = new FightingPokemon("Machop");
                rattata = new NormalPokemon("Rattata");
                bigboss = new Pokemon("Big Boss");
                System.out.println(gastly.getName());
                System.out.println(machop.getName());
                System.out.println(rattata.getName());
                System.out.println(bigboss.getName());
                gastly.displayClass();
                machop.displayClass();
                rattata.displayClass();
                bigboss.displayClass();
                gastly.setUniqueID("G1");
                machop.setUniqueID(12);
                System.out.println(gastly.getUniqueID());
                System.out.println(machop.getUniqueID());
            }
        };
        sections[1] = new Section() {

            @Override
            public void run() {
                gastly.checkElement();
                machop.checkElement();
                rattata.checkElement();
                gastly.specialSkill();
                machop.displayAura();
                gastly.displayAura();
                machop.specialSkill();
            }
        };
        sections[2] = new Section() {

            @Override
            public void run() {
                PokemonAction<GhostPokemon> gastlyAct = new PokemonAction<GhostPokemon>(gastly);
                PokemonAction<NormalPokemon> rattataAct = new PokemonAction<NormalPokemon>(rattata);
                gastlyAct.displayPokemonClass();
                rattataAct.displayPokemonClass();
                PokemonVersus(gastly, rattata);
                for (int i = 0; i < 7; i++) {
                    gastlyAct.attack();
                    rattataAct.defense();
                }
                for (int i = 0; i < 3; i++) {
                    rattataAct.attack();
                    gastlyAct.defense();
                }
                rattataAct.useSkill();
                gastlyAct.useSkill();
                rattataAct.run();
            }
        };
        sections[3] = new Section() {

            @Override
            public void run() {
                System.out.println("New Battle Found");
                PokemonAction<FightingPokemon> machopAct = new PokemonAction<FightingPokemon>(machop);
                PokemonAction<Pokemon> bigbossAct = new PokemonAction<Pokemon>(bigboss);
                machopAct.displayPokemonClass();
                bigbossAct.displayPokemonClass();
                PokemonVersus(bigboss, machop);
                for (int i = 0; i < 4; i++) {
                    machopAct.attack();
                    bigbossAct.defense();
                }
                for (int i = 0; i < 8; i++) {
                    bigbossAct.attack();
                    machopAct.defense();
                }
                machopAct.useSkill();
                bigbossAct.useSkill();
                machopAct.run();
                System.out.println("All Battle Finished");
            }
        };

        for (int i = 0; i < 4; i++) {
            System.out.printf("--- Section %d ---\n", i + 1);
            sections[i].run();
        }
    }
}