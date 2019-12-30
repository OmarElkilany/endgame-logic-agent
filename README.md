
# Logic-based AI Agent

This repo contains an implementation of a logic-based agent which utilises successor-state-axioms to find a solution for a grid, where the agent needs to collect 4 infinity stones then go to the goal cell to terminate. The full description of the problem can be found in `project_description.pdf`.

The `Main.java` file  contains a method which converts a grid description to logical sentences and saves them in a Prolog file. This file is later used by the agent as its Knowledge Base (KB).

A thorough description and analysis of the agent's inner workings can be found in `report.pdf`.
