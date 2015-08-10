function [f,g] = logistic_regression_vec(theta, X,y)
  %
  % Arguments:
  %   theta - A column vector containing the parameter values to optimize.
  %   X - The examples stored in a matrix.  
  %       X(i,j) is the i'th coordinate of the j'th example.
  %   y - The label for each example.  y(j) is the j'th example's label.
  %
  m=size(X,2);
  
  % initialize objective value and gradient.
  f = 0;
  g = zeros(size(theta));
  

  %
  % TODO:  Compute the logistic regression objective function and gradient 
  %        using vectorized code.  (It will be just a few lines of code!)
  %        Store the objective function value in 'f', and the gradient in 'g'.
  %
%%% YOUR CODE HERE %%%
% MICHAL START ---------------------------------------------
%
% i              - poradi vzorku
% inputX         - vstupy pro vzorek i
% outputCorrectY - spravna vystupni hodnota pro vzorek i
% outputH        - predikce pro vstup pro vzorek i
% err            - chyba pro vzorek i
% f              - sumarni chyba pres vsechny vzorky = objective function
% diff           - gradient pro vzorek i
% g              - sumarni gradient pres vsechny vzorky
%printf("X je %dx%d\n",size(X,1),size(X,2));
%printf("theta je %dx%d\n",size(theta,1),size(theta,2));
%printf("y correct je %dx%d\n",size(y,1),size(y,2));

Pronasobek=bsxfun(@times, X, theta);
Sums=sum(Pronasobek,1);
%printf("Sums je %dx%d\n",size(Sums,1),size(Sums,2));

OutputsH=arrayfun(@(x) 1/(1+exp(-x)), Sums);
%printf("OutputsH je %dx%d\n",size(OutputsH,1),size(OutputsH,2));

Diffs=OutputsH.-y;
%printf("Diffs je %dx%d\n",size(Diffs,1),size(Diffs,2));

Errors=bsxfun(@(h,c) c.*log(h)+(1-c).*log(1-h), OutputsH, y);
%printf("Errors je %dx%d\n",size(Errors,1),size(Errors,2));

f=-sum(Errors,2);
%printf("f je %dx%d\n",size(f,1),size(f,2));

Grads=bsxfun(@times, X, Diffs);
%printf("Grads je %dx%d\n",size(Grads,1),size(Grads,2));

g=sum(Grads,2);
%printf("g je %dx%d\n",size(g,1),size(g,2));
endfunction
% MICHAL END ---------------------------------------------
