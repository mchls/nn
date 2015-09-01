// *********************************************************************************************************************
// MAXIMA 
spustit: wxmamxima
zadat prikaz a stisknout shift+enter

k nastaveni hodnot se pouziva ':' - ('a:3')
k definici funkci se pouziva  ':=' - ('f(x):=x^2;')
posledni vystup je dostupny pres '%'
jeste starsi je dostupny pres '%on' kde n je pocet vystupu

? solve       - help na konkretni prikaz

%e %pi %i - konstanty, i je imaginarni cislo
inf/minf - +/- nekonecno; infinity je complexni nekonecno

log10(x):=log(x)/log(10);
log10(1000), numer;
logi(z):=1/(1+exp(-z));
diff(logi(z),z),expand;

wxplot2d([x^2], [x,-5,5], [y,-1,25]);
solve([x+y=5,3*x-y=3],[x,y]);

factor(30!);
factor(x^2+34*x+189);
float(sin(%pi/3));
wxplot2d([x^2,x^3,x^4], [x,-5,5], [y,-1,35]);
plot3d(x^2-y^2,[x,-2,2],[y,-2,2],[grid,12,12]);
float(1/3)

zjednoduseni zlomku / trigonometrickych vypoctu
ratsimp((x^2-1)/(x+1));
trigsimp(2*cos(x)^2+sin(x)^2);
trigexpand(sin(2*x)+cos(2*x));

tech(%); - posledni vzorec do TeXu

integrate(x+2/(x-3),x,0,1);
integrate(cos(sin(x+1)),x,0,1);  // neumi spocitat
romberg(cos(sin(x+1)),x,0,1);    // vyresime numericky

