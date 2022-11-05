<template>
  <div id="echart-line" :style="{ width: '100%', height: '100%' }"></div>
</template>

<script>
import * as echarts from "echarts";
import request from "@/utils/request.js";
import axios from "axios";

export default {
  name: "ChartLine",
  methods: {
    initChart() {
      let getchart = echarts.init(document.getElementById("echart-line"));

      let option = {
        title: {
          text: "当前天气19°C",
        },
        tooltip: {
          trigger: "axis",
        },
        legend: {},
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: "none",
            },
            dataView: { readOnly: false },
            magicType: { type: ["line", "bar"] },
            restore: {},
            saveAsImage: {},
          },
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
          axisLabel: {
            formatter: "{value} °C",
          },
        },
        series: [
          {
            name: "Highest",
            type: "line",
            data: [10, 11, 13, 11, 12, 12, 9],
            markPoint: {
              data: [
                { type: "max", name: "Max" },
                //   { type: 'min', name: 'Min' }
              ],
            },
            markLine: {
              data: [{ type: "average", name: "Avg" }],
            },
          }
    
        ],
      };
      getchart.setOption(option);
    },
  },
};
</script>
