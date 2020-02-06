package example.com.menuexample;

import android.app.Activity;

/**
 * Created by lucasnoga on 05/10/2017.
 */

public class Menu2 extends Activity {

    Titre racoleur, j'en conviens, mais qui révèle une vérité qu'il vous faut considérer :
    le bouton Menu est amené à disparaître. :o De manière générale, les utilisateurs n'utilisent pas ce bouton, il n'est pas assez visuel pour eux,
    ce qui fait qu'ils n'y pensent pas ou ignorent son existence. C'est assez grave, oui. Je vous apprends à l'utiliser parce que
    c'est quand même sacrément pratique et puissant, mais c'est à vous de faire la démarche d'apprendre à l'utilisateur comment
    utiliser correctement ce bouton, avec un Toast par exemple.

    Il existe des solutions qui permettent de se passer de ce menu. Android a introduit dans son API 11 (Android 3.0)
    l'ActionBar, qui est une barre de titre étendue sur laquelle il est possible d'ajouter des widgets de façon à disposer
    d'options constamment visibles. Cette initiative a été efficace puisque le taux d'utilisation de l'ActionBar est bien supérieur à celui du bouton Menu.

    Cependant, pour notre cours, cette ActionBar n'est pas disponible puisque nous utilisons l'API 7, et qu'il n'est pas
    question d'utiliser l'API 11 rien que pour ça — vous ne toucheriez plus que 5 % des utilisateurs de l'Android Market,
    au lieu des 98 % actuels… Il existe des solutions alternatives, comme celle-ci qui est officielle ou celle-là qui est puissante.
    Je vous invite à les découvrir par vous-mêmes. ;)

    Histoire de retourner le couteau dans la plaie, sachez que les menus contextuels sont rarement utilisés, puisqu'en général
    l'utilisateur ignore leur présence ou ne sait pas comment les utiliser (faire un appui long, c'est compliqué pour l'utilisateur, vraiment >_ ).
    Encore une fois, vous pouvez enseigner à vos utilisateurs comment les utiliser, ou bien ajouter une alternative plus visuelle
    pour ouvrir un menu sur un objet. Ça tombe super bien, c'est le sujet du prochain chapitre.

    La création d'un menu se fait en XML pour tout ce qui est statique et en Java pour tout ce qui est dynamique.
    La déclaration d'un menu se fait obligatoirement avec un élément menu à la racine du fichier et contiendra des éléments item.
    Un menu d'options s'affiche lorsque l'utilisateur clique sur le bouton de menu de son appareil. Il ne sera affiché que si le fichier
    XML représentant votre menu est désérialisé dans la méthode boolean onCreateOptionsMenu(Menu menu) et que vous avez donné des actions à
    chaque item dans la méthode boolean onOptionsItemSelected(MenuItem item).

    Un menu contextuel s'affiche lorsque vous appuyez longtemps sur un élément de votre interface.
    Pour ce faire, vous devez construire votre menu à partir de la méthode void onCreateContextMenu(ContextMenu menu, View vue, ContextMenu.ContextMenuInfo menuInfo)
    et récupérer la vue qui a fait appel à votre menu contextuel à partir de la méthode boolean onContextItemSelected(MenuItem item).
    Sachez tout de même que le bouton menu physique tend à disparaitre de plus en plus pour un menu tactile.
}
