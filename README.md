# decision_engine

a decision engine which takes in personal code, loan amount, loan period in months and returns a decision (negative or positive) and the amount.


# CONSTRAINT

#Minimum input and output sum can be 2000 €


#Maximum input and output sum can be 10000 €

#Minimum loan period can be 12 months 


#Maximum loan period can be 60 months


# USERDETAILS HARD CODED FROM COMMANDLINE RUNNER

#49002010965 - debt

#49002010976 - segment 1 (credit_modifier = 100)

#49002010987 - segment 2 (credit_modifier = 300) 

#49002010998 - segment 3 (credit_modifier = 1000)


#credit score = (credit modifier / loan amount) * loan period

#If a person has debt then we do not approve any amount. 

#If a person has no debt then we take the identifier and use it for calculating person`s credit score taking into account the requested input.

#If the result is less than 1 then we would not approve such sum, 

#if the result is larger or equal than 1 then we would approve this sum.

#If a suitable loan amount is not found within the selected period, the decision engine should also try to find a new suitable period.

# ui : reactjs : https://github.com/amoloye/decision_engine_ui

# amount calculation takes preference to period(months) when finding the suitable loan
