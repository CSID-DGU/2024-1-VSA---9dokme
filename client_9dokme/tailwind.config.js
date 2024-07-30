// //custom utiity 정의
// module.exports = {
//   content: ["./src/**/*.{js,jsx,ts,tsx}"],
//   theme: {
//     extend: {
//       fontSize: {
//         "vw-1": "1vw",
//         "vw-2": "2vw",
//       },
//       colors: {
//         customColor: "#C5B5F7",
//         customColor2: "#F3F5FF",
//         submitColor: "#2519B2",
//         customGradient: {
//           start: "#918FFF", // 0% 위치의 색상
//           midStart: "#5956FF", // 45% 위치의 색상
//           midEnd: "#3F3CFF", // 55% 위치의 색상
//           endStart: "#3431FF", // 79% 위치의 색상
//           end: "#0011FF", // 100% 위치의 색상
//         },
//       },
//       opacity: {
//         20: "0.2",
//       },
//       gridTemplateColumns: {
//         "3by5": "3fr 5fr",
//       },
//     },
//   },
//   variants: {},
//   plugins: [require("@tailwindcss/aspect-ratio")],
// };
const plugin = require("tailwindcss/plugin");

module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      fontSize: {
        "vw-1": "1vw",
        "vw-2": "2vw",
      },
      colors: {
        customColor: "#C5B5F7",
        customColor2: "#F3F5FF",
        submitColor: "#2519B2",
        // 단일 색상으로 정의
      },
      opacity: {
        20: "0.2",
      },
      gridTemplateColumns: {
        "3by5": "3fr 5fr",
      },
    },
  },
  plugins: [
    require("@tailwindcss/aspect-ratio"),
    plugin(function ({ addUtilities, theme }) {
      const newUtilities = {
        ".bg-custom-gradient": {
          backgroundImage: `linear-gradient(to right, ${theme(
            "colors.customGradient.start"
          )}, ${theme("colors.customGradient.midStart")} 45%, ${theme(
            "colors.customGradient.midEnd"
          )} 55%, ${theme("colors.customGradient.endStart")} 79%, ${theme(
            "colors.customGradient.end"
          )} 100%)`,
        },
      };
      addUtilities(newUtilities, ["responsive", "hover"]);
    }),
  ],
};
