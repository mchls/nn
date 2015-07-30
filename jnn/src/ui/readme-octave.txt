
Pro octave je treba prelozit c programy:
cd  ~/pgms/michals/nn/jnn/stanford_dl_ex/common/minFunc_2012/minFunc/mex
mkoctfile --mex  lbfgsProdC.c
mkoctfile --mex  mcholC.c
mkoctfile --mex lbfgsC.c
mkoctfile --mex lbfgsAddC.c
cp *.mex ../compiled
rm *.mex *.o



// *******************************************************************************
http://ufldl.stanford.edu/tutorial/supervised/LinearRegression/
cd ~/pgms/michals/nn/jnn/stanford_dl_ex/ex1
octave octave ex1a_linreg.m

Vstupni parametr theta je sloupecek vah o velikosti 14: 
Vstupni parametr X je matice majici n=14 sloupecku=parametru a m=400 radku=zaznamu: 
Vstupni parametr y je radek o velikosti 400: 
       111        116     1.00000e+00     4.46105e+03     1.35347e-03
Directional Derivative below progTol
Optimization took 1.388637 seconds.
RMS training error: 4.722841
RMS testing error: 6.155792

// *******************************************************************************


// poznamky k syntaxi ---------------------------------------------------
function r=kvadrat(x)
r=x*x;
endfunction

x=-2:0.1:2

# volani funkce kvadrat pro kazdy element z vektoru x
plot (x, arrayfun(@(a) kvadrat(a),x))
plot (x,arrayfun(@(a) kvadrat(a),x), x, sqrt(x))   # vykresleni dvou funkci najednou


help plot

# vyhazeni imaginarnich vysledku z pole
w(w == real(w))

vsechny indexy do poli jsou od 1!


