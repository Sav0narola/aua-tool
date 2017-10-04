<template>
  <div id="app">
    <img src="./assets/logo.png">
    <chart></chart>
    <div class="container">
      <custom-chart></custom-chart>
    </div>
  </div>
</template>

<script>
  import Chart from './components/Chart'
  import CustomChart from './components/LineChart'

  export default {
    name: 'app',
    components: {
      Chart,
      CustomChart
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }


  .container {
    max-width: 800px;
    margin: 0 auto
  }
</style>
