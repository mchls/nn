
Octave 4.0 na Ubuntu:

https://scivision.co/compiling-octave-4-0-on-ubuntu-14-04/

Ubuntu:
sudo apt-get install gawk gfortran gperf flex libbison-dev libqhull-dev libglpk-dev libcurl4-gnutls-dev libfltk1.3-dev librsvg2-dev libqrupdate-dev libgl2ps-dev libosmesa6-dev libarpack2-dev libqscintilla2-dev libreadline-dev libncurses5-dev libhdf5-dev llvm-dev libqt4-dev default-jdk libfftw3-dev libgraphicsmagick++-dev libjasper-dev libfreeimage-dev transfig epstool
sudo apt-get install gnuplot 

wget https://ftp.gnu.org/gnu/octave/octave-4.0.0.tar.xz
tar xf octave-4*.xz

export PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
cd octave-4*
./configure --enable-jit --prefix=/opt/octave4.0

make
sudo make install

// **********************************************************************************************************************
// poznamky k syntaxi ---------------------------------------------------

ezplot("1/(1+exp(-x))")

fplot("1/(1-exp(-x))", [0.1,1])


# definice funkce
function r=kvadrat(x)
r=x*x;
endfunction

# naplneni vektoru hodnotami od, krok, do
x=-2:0.1:2

# volani funkce kvadrat pro kazdy element z vektoru x
plot (x, arrayfun(@(a) kvadrat(a),x))
plot (x,arrayfun(@(a) kvadrat(a),x), x, sqrt(x))   # vykresleni dvou funkci najednou


help plot

# vyhazeni imaginarnich vysledku z pole
w(w == real(w))

vsechny indexy do poli jsou od 1!

X' znamena otoceni vektoru
x .* x znamena nenasobit vektorove, ale element po elementu


// *********************************************************************************************************************
// MAXIMA 
spustit: wxmamxima
zadat prikaz a stisknout shift+enter

k nastaveni hodnot se pouziva ':' - ('a:3')
k definici funkci se pouziva  ':=' - ('f(x):=x^2;')
posledni vystup je dostupny pres '%'
jeste starsi je dostupny pres '%on' kde n je pocet vystupu

log10(x):=log(x)/log(10);
log10(1000), numer;
logi(z):=1/(1+exp(-z));
diff(logi(z),z),expand;
