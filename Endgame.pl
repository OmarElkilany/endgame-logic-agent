:- discontiguous ironMan/3.
:- discontiguous stone/3.
:- include('./exampleGrid.pl').

ironMan(X, Y, result(A, S)):-
    ironMan(OldX, OldY, S),
    grid(M,N),
    (
        (
            (
                A = right, OldX = X, Y is OldY + 1, Y < M;
                A = left, OldX = X, Y is OldY - 1, Y >= 0;
                A = up, OldY = Y, X is OldX - 1, X >= 0;
                A = down, OldY = Y, X is OldX + 1, X < N
            )
        );
        (
            (A = collect, stone(OldX, OldY, S)), X = OldX, Y = OldY
        )
    ).

stone(X, Y, result(A, S)):-
    (
        stone(X, Y, S), (A = right ; A = left; A = up; A = down; A = collect, \+ ironMan(X, Y, S))
    ).

snapped(S):-
    S = result(snap, Sp), thanos(X, Y), ironMan(X, Y, Sp), \+ stone(_, _, Sp).