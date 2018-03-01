#!/bin/bash

echo "a_example"
java -cp target/classes/ main.Main /home/hlib/activeeon/ashcode/a_example.in /home/hlib/activeeon/ashcode/a_example.out

echo "b_example"

java -cp target/classes/ main.Main /home/hlib/activeeon/ashcode/b_should_be_easy.in /home/hlib/activeeon/ashcode/b_should_be_easy.out

echo "c_example"

java -cp target/classes/ main.Main /home/hlib/activeeon/ashcode/c_no_hurry.in /home/hlib/activeeon/ashcode/c_no_hurry.out

echo "d_example"

java -cp target/classes/ main.Main /home/hlib/activeeon/ashcode/d_metropolis.in /home/hlib/activeeon/ashcode/d_metropolis.out

echo "e_example"

java -cp target/classes/ main.Main /home/hlib/activeeon/ashcode/e_high_bonus.in /home/hlib/activeeon/ashcode/e_high_bonus.out