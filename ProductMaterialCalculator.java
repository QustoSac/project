public class ProductMaterialCalculator {
    public static int calculateMaterial(String productTypeId, String materialTypeId, int productQuantity, int param1,
            int param2) {
        // Коэффициенты для типов продукции и материалов (в реальном приложении это
        // можно хранить в базе данных)
        double productCoefficient;
        double materialDefectRate;

        switch (productTypeId) {
            case "A":
                productCoefficient = 1.2;
                break;
            case "B":
                productCoefficient = 1.5;
                break;
            default:
                return -1; // Несуществующий тип продукции
        }

        switch (materialTypeId) {
            case "X":
                materialDefectRate = 0.05;
                break;
            case "Y":
                materialDefectRate = 0.10;
                break;
            default:
                return -1; // Несуществующий тип материала
        }

        // Расчет необходимого количества материала
        int requiredMaterial = (int) Math
                .ceil(productQuantity * param1 * param2 * productCoefficient * (1 + materialDefectRate));
        return requiredMaterial;
    }
}
