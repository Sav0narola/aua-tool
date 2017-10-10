<template>
  <div id="app">
    <img src="./assets/auaLogo.svg">
    <chart></chart>
    <div class="container">
      <div class="Chart">
        <line-example></line-example>
      </div>
    </div>
  </div>
</template>

<script>
  import Chart from './components/Chart';
  import LineExample from './components/LineChart';

  export default {
    name: 'app',
    components: {
      Chart,
      LineExample,
    },
  };
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

  .Chart {
    background: #212733;
    border-radius: 15px;
    box-shadow: 0px 2px 15px rgba(25, 25, 25, 0.27);
    margin:  25px 0;
  }

</style>
