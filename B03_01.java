package Hw3;

class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {this.real = real; this.imag = imag;}

    public ComplexNumber add(ComplexNumber other) {
    	return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new ArithmeticException("ERROR: division by 0!");
        }
        double newReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double newImag = (this.imag * other.real - this.real * other.imag) / denominator;
        return new ComplexNumber(newReal, newImag);
    }

    @Override
    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + (-imag) + "i";
        }
    }

    public static ComplexNumber multiplyArray(ComplexNumber[] numbers) {
        ComplexNumber result = new ComplexNumber(1, 0);
        for (int i = 0; i < numbers.length; i++) {
            result = result.multiply(numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, -3);
        ComplexNumber c3 = new ComplexNumber(-4, 6);
        ComplexNumber[] array = {c1, c2, c3};

        System.out.println("Add: " + c1.add(c2));
        System.out.println("Subtract: " + c1.subtract(c2));
        System.out.println("Multiply: " + c1.multiply(c2));
        System.out.println("Divide: " + c1.divide(c2));

        ComplexNumber product = ComplexNumber.multiplyArray(array);
        System.out.println("Array product: " + product);
    }
}
