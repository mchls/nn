function [f,g] = linear_regression(theta, X,y)
  %
  % Arguments:
  %   theta - A vector containing the parameter values to optimize.
  %   X - The examples stored in a matrix.
  %       X(i,j) is the i'th coordinate of the j'th example.
  %   y - The target value for each example.  y(j) is the target for example j.
  %
  
  m=size(X,2);
  n=size(X,1);

  f=0;
  g=zeros(size(theta));

  %
  % TODO:  Compute the linear regression objective by looping over the examples in X.
  %        Store the objective function value in 'f'.                                    objective je to same jako cost function
  %
  % TODO:  Compute the gradient of the objective with respect to theta by looping over
  %        the examples in X and adding up the gradient for each example.  Store the
  %        computed gradient in 'g'.
  
%%% YOUR CODE HERE %%%

% MICHAL START --------------------
%fprintf ("Vstupni parametr theta je sloupecek vah o velikosti %d: \n",size(theta,1));
%theta
%printf ("Vstupni parametr X je matice majici n=%d sloupecku=parametru a m=%d radku=zaznamu: \n",size(X,1),size(X,2));
%X
%printf ("Vstupni parametr y je radek o velikosti %d: \n",size(y,2));
%y
%
% i              - poradi vzorku
% inputX         - vstupy pro vzorek i
% outputCorrectY - spravna vystupni hodnota pro vzorek i
% outputH        - predikce pro vstup pro vzorek i
% err            - chyba pro vzorek i
% f              - sumarni chyba pres vsechny vzorky = objective function
% diff           - gradient pro vzorek i
% g              - sumarni gradient pres vsechny vzorky
for i = 1:m
    inputX = X(:,i);
    outputCorrectY = y(i);
    outputH = sum(theta .* inputX);
    err = 0.5 * ((outputH-outputCorrectY)^2);
    f += err;
    diff = inputX * (outputH-outputCorrectY);
    g += diff;
end     
endfunction
% MICHAL END --------------------
          
          
