# k-NN

A Java implementation of the k-nearest neighbors algorithm. The program reads training and test datasets, classifies test records and accepts custom feature vectors for classification through the console.

## Features

- k-NN classification.
- Euclidean distance calculation between feature vectors.
- Prediction based on the most frequent label among the `k` nearest neighbors.
- Classification of the test dataset.
- Interactive classification of custom vectors entered through the console.
- Confusion matrix output.
- Supporting linear algebra operations on vectors and matrices.

## Tech Stack

- Java
- Java standard library
- IntelliJ IDEA project structure (`mpp1.iml`)

## Getting Started

Requirements:

- A JDK
- A Java development environment, such as IntelliJ IDEA, or command-line compilation tools

Before running the program, update the hardcoded dataset path in `ReadData.java` as described in the Data section below.

From the repository root:

```bash
cd mpp1/src
javac *.java
java Main
```

The program prompts for `k`, prints predictions for the test dataset, displays evaluation results and then accepts custom vectors.

## Data

The repository includes the following datasets:

```text
iris.train.data
iris.test.data
wdbc.data
wdbc.test.data
```

The current `Main.java` uses these files by default:

```text
iris.train.data
iris.test.data
```

The current implementation of `ReadData.java` uses this hardcoded local directory:

```text
/Users/karo/Desktop/Ćwiczenia 1 - kNN/
```

Change this path to the directory containing your dataset files, or place the files at the expected location.

## Project Structure

```text
k-NN/
├── mpp1/src/
│   ├── Evaluator.java
│   ├── KNN.java
│   ├── LinAlg.java
│   ├── Main.java
│   ├── Point.java
│   └── ReadData.java
├── iris.train.data
├── iris.test.data
├── wdbc.data
└── wdbc.test.data
```

## Notes

The project does not use external libraries. Automated tests are not included.
