package arg.vue;

import arg.dao.ASCIIBuilder;

public class MenuPrincipal {

    public static void Title() throws java.lang.Exception {

        ASCIIBuilder.ASCIIBuild(" A R G");
        Message.Msg("                   Another Rogue Game         ");
        Message.Msg("                Version 0.6 BEFORE REBOOT ");
        Message.Msg("         ---Appuyez sur Entrer pour commençer--- ");
        MenuWorld.CarteDuMonde();
    }

}
