import java.util.Arrays;
import java.util.Random;

public class NeuralNetwork {
    private int inputSize;
    private int hiddenSize;
    private int outputSize;

    private double[][] weightsInputHidden;
    private double[][] weightsHiddenOutput;

    private double[] hiddenLayer;
    private double[] outputLayer;

    NeuralNetwork(int inputSize, int hiddenSize, int outputSize) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;

        this.weightsInputHidden = new double[inputSize][hiddenSize];
        this.weightsHiddenOutput = new double[hiddenSize][outputSize];

        this.hiddenLayer = new double[hiddenSize];
        this.outputLayer = new double[outputSize];

        initializeWeights();
    }

    private void initializeWeights() {
        Random rand = new Random();

        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                weightsInputHidden[i][j] = rand.nextDouble();
            }
        }

        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < outputSize; j++) {
                weightsHiddenOutput[i][j] = rand.nextDouble();
            }
        }
    }

    private double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    private double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public double[] forward(double[] input) {
        Arrays.fill(hiddenLayer, 0.0);
        Arrays.fill(outputLayer, 0.0);

        // Forward pass from input to hidden layer
        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                hiddenLayer[i] += input[j] * weightsInputHidden[j][i];
            }
            hiddenLayer[i] = sigmoid(hiddenLayer[i]);
        }

        // Forward pass from hidden to output layer
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                outputLayer[i] += hiddenLayer[j] * weightsHiddenOutput[j][i];
            }
            outputLayer[i] = sigmoid(outputLayer[i]);
        }

        return Arrays.copyOf(outputLayer, outputSize);
    }

    public void train(double[] input, double[] target, double learningRate, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            // Forward pass
            forward(input);

            // Backpropagation
            double[] outputError = new double[outputSize];
            for (int i = 0; i < outputSize; i++) {
                outputError[i] = target[i] - outputLayer[i];
            }

            double[] outputDelta = new double[outputSize];
            for (int i = 0; i < outputSize; i++) {
                outputDelta[i] = outputError[i] * sigmoidDerivative(outputLayer[i]);
            }

            double[] hiddenError = new double[hiddenSize];
            for (int i = 0; i < hiddenSize; i++) {
                for (int j = 0; j < outputSize; j++) {
                    hiddenError[i] += outputDelta[j] * weightsHiddenOutput[i][j];
                }
            }

            double[] hiddenDelta = new double[hiddenSize];
            for (int i = 0; i < hiddenSize; i++) {
                hiddenDelta[i] = hiddenError[i] * sigmoidDerivative(hiddenLayer[i]);
            }

            // Update weights
            for (int i = 0; i < inputSize; i++) {
                for (int j = 0; j < hiddenSize; j++) {
                    weightsInputHidden[i][j] += learningRate * input[i] * hiddenDelta[j];
                }
            }

            for (int i = 0; i < hiddenSize; i++) {
                for (int j = 0; j < outputSize; j++) {
                    weightsHiddenOutput[i][j] += learningRate * hiddenLayer[i] * outputDelta[j];
                }
            }
        }
    }
}