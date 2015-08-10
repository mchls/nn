function [f,g] = logistic_regression(theta, X,y)
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
  % TODO:  Compute the objective function by looping over the dataset and summing
  %        up the objective values for each example.  Store the result in 'f'.
  %
  % TODO:  Compute the gradient of the objective by looping over the dataset and summing
  %        up the gradients (df/dtheta) for each example. Store the result in 'g'.
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
for i = 1:m
    inputX = X(:,i);
    outputCorrectY = y(i);
    % sum(theta .* inputX); // LINEAR
    outputH = 1 / (1+ exp(-sum(theta .* inputX)));
   
    %err = ((outputH-outputCorrectY)^2); // LINEAR
    err = outputCorrectY * log(outputH) + (1 - outputCorrectY) * log(1 - outputH);
    f += -err;

    % stejna funkce jako pro LINEAR - ale ooutputH se pocita pre logistic funkci
    diff = inputX * (outputH-outputCorrectY);
    g += diff;
end     
endfunction
% MICHAL END ---------------------------------------------
