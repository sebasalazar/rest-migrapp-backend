package cl.sebastian.proyecto.rest.persistence.model;

public enum Code {
    /**
     * Producto Interno Bruto
     *
     * Código: PIB.
     *
     * Descripción: En macroeconomía, el producto interno bruto (PIB),​ conocido
     * también como producto interior o producto bruto interno (PBI), es una
     * magnitud macroeconómica que expresa el valor monetario de la producción
     * de bienes y servicios de demanda final de un país o región durante un
     * período determinado, normalmente de un año o trimestrales.
     *
     * Unidad: US$.
     */
    PIB {
        @Override
        public String getName() {
            return "Producto Interno Bruto";
        }

        @Override
        public String getDescription() {
            return "En macroeconomía, el producto interno bruto (PIB),​ conocido también como producto interior o producto bruto interno (PBI), es una magnitud macroeconómica que expresa el valor monetario de la producción de bienes y servicios de demanda final de un país o región durante un período determinado, normalmente de un año o trimestrales.";
        }

        @Override
        public String getUnit() {
            return "US$";
        }
    },
    /**
     * Tasa de desempleo anual.
     *
     * Código: TDA.
     *
     * Descripción: La tasa de desempleo anual, es el porcentaje de la población
     * activa (en condición de trabajar) que carece de empleo y, por lo tanto,
     * de salario.
     *
     * Unidad: Porcentaje (%)
     */
    TDA {
        @Override
        public String getName() {
            return "Tasa de desempleo anual.";
        }

        @Override
        public String getDescription() {
            return "La tasa de desempleo anual,  es el porcentaje de la población activa (en condición de trabajar) que carece de empleo y, por lo tanto, de salario.";
        }

        @Override
        public String getUnit() {
            return "%";
        }
    },
    /**
     * Inflación.
     *
     * Código: IFL.
     *
     * Descripción: La inflación, en economía, es el aumento generalizado y
     * sostenido de los precios de los bienes y servicios existentes en el
     * mercado durante un período de tiempo, generalmente un año. Cuando el
     * nivel general de precios sube, con cada unidad de moneda se adquieren
     * menos bienes y servicios. Es decir, que la inflación refleja la
     * disminución del poder adquisitivo de la moneda: una pérdida del valor
     * real del medio interno de intercambio y unidad de medida de una economía.
     * Una medida frecuente de la inflación es el índice de precios, que
     * corresponde al porcentaje anualizado de la variación general de precios
     * en el tiempo (el más común es el índice de precios al consumidor).
     *
     * Unidad: Porcentaje (%)
     */
    IFL {
        @Override
        public String getName() {
            return "Inflación.";
        }

        @Override
        public String getDescription() {
            return "La inflación, en economía, es el aumento generalizado y sostenido de los precios de los bienes y servicios existentes en el mercado durante un período de tiempo, generalmente un año. Cuando el nivel general de precios sube, con cada unidad de moneda se adquieren menos bienes y servicios. Es decir, que la inflación refleja la disminución del poder adquisitivo de la moneda: una pérdida del valor real del medio interno de intercambio y unidad de medida de una economía. Una medida frecuente de la inflación es el índice de precios, que corresponde al porcentaje anualizado de la variación general de precios en el tiempo (el más común es el índice de precios al consumidor).";
        }

        @Override
        public String getUnit() {
            return "%";
        }
    },
    /**
     *
     * Impuesto de Valor Añadido.
     *
     * Código: IVA.
     *
     * Descripción: El IVA es una carga fiscal sobre el consumo, es decir,
     * financiado por el consumidor como impuesto regresivo. El IVA es un
     * impuesto indirecto:​ no es percibido por el fisco directamente del
     * tributario, sino por el vendedor en el momento de toda transacción
     * comercial (transferencia de bienes o prestación de servicios).
     *
     * Unidad: Porcentaje (%).
     */
    IVA {
        @Override
        public String getName() {
            return "Impuesto de Valor Añadido.";
        }

        @Override
        public String getDescription() {
            return "El IVA es una carga fiscal sobre el consumo, es decir, financiado por el consumidor como impuesto regresivo. El IVA es un impuesto indirecto:​ no es percibido por el fisco directamente del tributario, sino por el vendedor en el momento de toda transacción comercial (transferencia de bienes o prestación de servicios).";
        }

        @Override
        public String getUnit() {
            return "%";
        }
    },
    /**
     * Presión Fiscal.
     *
     * Código: PRF
     *
     * Descripción: Presión tributaria o presión fiscal es un término económico
     * para referirse al porcentaje de los ingresos que los particulares y
     * empresas aportan efectivamente al Estado en concepto de tributos en
     * relación al producto bruto interno. De ese modo, la presión tributaria de
     * un país es el porcentaje del PIB recaudado por el Estado por impuestos,
     * tasas y otros tributos. Esto no incluye el IVA.
     *
     * Unidad: Porcentaje (%).
     */
    PRF {
        @Override
        public String getName() {
            return "Presión Fiscal.";
        }

        @Override
        public String getDescription() {
            return "Presión tributaria o presión fiscal es un término económico para referirse al porcentaje de los ingresos que los particulares y empresas aportan efectivamente al Estado en concepto de tributos en relación al producto bruto interno. De ese modo, la presión tributaria de un país es el porcentaje del PIB recaudado por el Estado por impuestos, tasas y otros tributos. Esto no incluye el IVA.";
        }

        @Override
        public String getUnit() {
            return "%";
        }
    },
    /**
     * Salario Mínimo (US$ a precios actuales).
     *
     * Código: SMI
     *
     * Descripción: La remuneración mínima, salario mínimo o sueldo mínimo, es
     * la cantidad mínima de dinero que se le paga a un trabajador en un
     * determinado país y a través de una ley establecida oficialmente, para un
     * determinado período laboral (hora, día o mes), que los empleadores deben
     * pagar a sus trabajadores por sus labores.
     *
     * Unidad: US$.
     */
    SMI {
        @Override
        public String getName() {
            return "Salario Mínimo (US$ a precios actuales).";
        }

        @Override
        public String getDescription() {
            return "La remuneración mínima, salario mínimo o sueldo mínimo, es la cantidad mínima de dinero que se le paga a un trabajador en un determinado país y a través de una ley establecida oficialmente, para un determinado período laboral (hora, día o mes), que los empleadores deben pagar a sus trabajadores por sus labores.";
        }

        @Override
        public String getUnit() {
            return "US$";
        }
    },
    /**
     * Tasa de cambio (US$ a precios actuales).
     *
     * Código: TSC
     *
     * Descripción: La tasa o tipo de cambio entre dos divisas es la tasa o
     * relación de proporción que existe entre el valor de una y la otra. Dicha
     * tasa es un indicador que expresa cuántas unidades de una divisa se
     * necesitan para obtener una unidad de la otra. Por ejemplo, si la tasa de
     * cambio entre el euro y el dólar estadounidense EUR/USD fuera de 1.12,
     * ello significa que el euro equivale a 1.12 dólares.
     *
     * Unidad: US$ (por unidad)
     */
    TSC {
        @Override
        public String getName() {
            return "Tasa de cambio  (US$ a precios actuales).";
        }

        @Override
        public String getDescription() {
            return "La tasa o tipo de cambio entre dos divisas es la tasa o relación de proporción que existe entre el valor de una y la otra. Dicha tasa es un indicador que expresa cuántas unidades de una divisa se necesitan para obtener una unidad de la otra. Por ejemplo, si la tasa de cambio entre el euro y el dólar estadounidense EUR/USD fuera de 1.12, ello significa que el euro equivale a 1.12 dólares. ";
        }

        @Override
        public String getUnit() {
            return "US$";
        }
    },
    /**
     * Doing Business Index.
     *
     * Código: DBI
     *
     * Descripción: El índice de facilidad para hacer negocios (en inglés, ease
     * of doing business index) es un índice creado por el Grupo del Banco
     * Mundial.1​ La clasificación de los más altos índices indican el mejor,
     * generalmente el más simple en cuanto a las regulaciones para las
     * empresas, y el de mayor protección de los derechos de propiedad. La
     * investigación empírica financiada por el Banco Mundial para justificar su
     * trabajo pretende mostrar que el efecto de las mejoras de estas normas en
     * el crecimiento económico es fuerte.
     *
     * Unidad: Posición en el ranking (menos es mejor).
     */
    DBI {
        @Override
        public String getName() {
            return "Doing Business Index.";
        }

        @Override
        public String getDescription() {
            return "El índice de facilidad para hacer negocios (en inglés, ease of doing business index) es un índice creado por el Grupo del Banco Mundial.1​ La clasificación de los más altos índices indican el mejor, generalmente el más simple en cuanto a las regulaciones para las empresas, y el de mayor protección de los derechos de propiedad. La investigación empírica financiada por el Banco Mundial para justificar su trabajo pretende mostrar que el efecto de las mejoras de estas normas en el crecimiento económico es fuerte.";
        }

        @Override
        public String getUnit() {
            return "Ranking";
        }
    };

    /**
     *
     * @return El nombre del indicador.
     */
    public abstract String getName();

    /**
     *
     * @return La descripción del indicador.
     */
    public abstract String getDescription();

    /**
     *
     * @return La unidad del indicador.
     */
    public abstract String getUnit();
}
