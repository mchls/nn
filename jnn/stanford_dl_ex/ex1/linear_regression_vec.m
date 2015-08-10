function [f,g] = linear_regression_vec(theta, X,y)
  %
  % Arguments:
  %   theta - A vector containing the parameter values to optimize.
  %   X - The examples stored in a matrix.
  %       X(i,j) is the i'th coordinate of the j'th example.
  %   y - The target value for each example.  y(j) is the target for example j.
  %
  m=size(X,2);
  
  % initialize objective value and gradient.
  f = 0;
  g = zeros(size(theta));

  %
  % TODO:  Compute the linear regression objective function and gradient 
  %        using vectorized code.  (It will be just a few lines of code!)
  %        Store the objective function value in 'f', and the gradient in 'g'.
  %
%%% YOUR CODE HERE %%%
% MICHAL START --------------------
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
%printf("Pronasobek je %dx%d\n",size(Pronasobek,1),size(Pronasobek,2));

%printf("Test vysledek: %f x %f = %f\n",X(2,2),theta(2),Pronasobek(2,2));

OutputsH=sum(Pronasobek,1);
%printf("OutputsH je %dx%d\n",size(OutputsH,1),size(OutputsH,2));

Diffs=OutputsH.-y;
%printf("Diffs je %dx%d\n",size(Diffs,1),size(Diffs,2));

Errors=0.5.*(sum((Diffs).^2,1));
%printf("Errors je %dx%d\n",size(Errors,1),size(Errors,2));

f=sum(Errors,2);
%printf("f je %dx%d\n",size(f,1),size(f,2));

Grads=bsxfun(@times, X, Diffs);
%printf("Grads je %dx%d\n",size(Grads,1),size(Grads,2));

g=sum(Grads,2);
%printf("g je %dx%d\n",size(g,1),size(g,2));

% ----------------- iteraci:
%for i = 1:m
%    inputX = X(:,i);
%    outputCorrectY = y(i);
%    outputH = sum(theta .* inputX);
%    err = 0.5 * ((outputH-outputCorrectY)^2);
%    f += err;
%    diff = inputX * (outputH-outputCorrectY);
%    g += diff;
%end     
endfunction
% MICHAL END --------------------
          
