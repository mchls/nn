


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

X' znamena otoceni vektoru
x .* x znamena nenasobit vektorove, ale element po elementu

